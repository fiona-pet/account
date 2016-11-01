package cn.fiona.pet.account.service;

import cn.fiona.pet.account.repository.MessageDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User: baiqw
 * Date: 14-12-9
 * Time: 下午3:45
 */
public class MessageServiceImpl implements MessageService {

    private static final Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

    @Autowired
    private MessageDao messageDao;

    @Override
    public Boolean send(String phoneNumber, String content) {
        logger.debug("phone_number:{}, content:{}", phoneNumber, content);
        return true;
    }

    @Override
    public Boolean sendVerificationCode(String phoneNumber) {
        logger.debug("phone_number:{}", phoneNumber);
        return true;
    }

    @Override
    public Boolean verificationCode(String phoneNumber, String checkCode) {
        logger.debug("phone_number:{},check_code:{}", phoneNumber,checkCode);
        return true;
    }
}
