package cn.fiona.pet.account.provider;

import org.junit.Test;
import org.springside.modules.security.utils.Digests;
import org.springside.modules.utils.Encodes;

/**
 * Created by tom on 2017/8/13.
 */
public class TestUser {
    @Test
    public void test(){
        byte[] salt = Encodes.decodeHex("7efbd59d9741d34f");

        byte[] hashPassword = Digests.sha1("fiona".getBytes(), salt, 1024);

        System.out.println(Encodes.encodeHex(hashPassword));
    }
}
