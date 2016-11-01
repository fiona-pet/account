package cn.fiona.pet.account.service;

/**
 * 短信消息 服务层
 * Created by baiqunwei on 16/2/26.
 */
public interface MessageService{
    /**
     * 发送短信
     * @param phoneNumber 电话号码
     * @param content 内容
     * @return 发送是否成功
     */
    public Boolean send(String phoneNumber, String content);

    /**
     * 发送短信 验证码
     * @param phoneNumber 电话号码
     * @return 发送是否成功
     */
    public Boolean sendVerificationCode(String phoneNumber);

    /**
     * 验证 验证码
     * @param phoneNumber 电话号码
     * @param checkCode 验证码
     * @return
     */
    public Boolean verificationCode(String phoneNumber,String checkCode);
}
