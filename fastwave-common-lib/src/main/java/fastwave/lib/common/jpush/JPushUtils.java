package fastwave.lib.common.jpush;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;
import cn.jpush.api.schedule.ScheduleResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sx on 2018/6/27.
 */
public class JPushUtils {

    private Logger logger = LoggerFactory.getLogger(JPushUtils.class);

    private JPushUtils() {
    }

    private final static String APP_KEY = "326a8ccf21333759a733b368";

    private final static String MASTER_SECRET = "446db62e0c87f97ddeb0d969";

    private static JPushUtils instance;

    public static JPushUtils getInstance() {
        if (instance == null) {
            instance = new JPushUtils();
        }
        return instance;
    }

    private JPushClient initClient() {
        ClientConfig config = ClientConfig.getInstance();
        config.setMaxRetryTimes(5);
        config.setApnsProduction(false);    // development env
        config.setTimeToLive(60 * 60 * 24);
        return new JPushClient(MASTER_SECRET, APP_KEY,
                null, config);
    }

    private PushPayload buildPushPayload(PushData pushData, boolean toAll) {

        if (pushData.getTitle() == null || pushData.getTitle().isEmpty()) {
            pushData.setTitle("通知");
        }

        PushPayload pushPayload = null;
        Audience audience = null;
        if (toAll) {
            audience = Audience.all();
        } else {
            audience = Audience.registrationId(pushData.getRegistrationId());
        }

        pushPayload = PushPayload.newBuilder()
                .setAudience(audience)
                .setPlatform(Platform.android())
                .setNotification(Notification.android(pushData.getTitle(), pushData.getContent(), pushData.getParams()))
                .build();

        return pushPayload;
    }

    /**
     * 定时推送
     * @param pushData
     * @param time     时间（yyyy-MM-dd HH:mm:ss）
     * @param toAll    发送给所有人
     * @return
     */
    public boolean pushTiming(PushData pushData, String time,boolean toAll) {
        JPushClient jpushClient = initClient();
        PushPayload push = buildPushPayload(pushData,toAll);
        try {
            jpushClient.createSingleSchedule(pushData.getTitle(), time, push);
            return true;
        } catch (APIConnectionException e) {}
          catch (APIRequestException e) {}
        return false;
    }

    public boolean push(PushData pushData, boolean toAll) {

        JPushClient jpushClient = initClient();

        PushPayload payload = buildPushPayload(pushData,toAll);

        try {
            jpushClient.sendPush(payload);
            return true;
        } catch (APIConnectionException e) {
            logger.error("<-----------------------极光推送----------------------------->" +
                    "\nConnection error, should retry later", e);
            logger.error("<-----------------------极光推送----------------------------->");
        } catch (APIRequestException e) {
            logger.error("<----------------------极光推送----------------------------------------->" +
                    "\nShould review the error, and fix the request", e);
            logger.info("HTTP Status: " + e.getStatus());
            logger.info("Error Code: " + e.getErrorCode());
            logger.info("Error Message: " + e.getErrorMessage());
            logger.error("<-----------------------极光推送----------------------------->");
        }
        return false;
    }
}
