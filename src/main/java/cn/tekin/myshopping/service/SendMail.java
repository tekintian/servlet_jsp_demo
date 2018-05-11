package cn.tekin.myshopping.service;

import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

//该程序是用于发电子邮件的

public class SendMail {

    private MimeMessage mimeMsg;//MIME邮件对象

    private Session session;//邮件会话对象
    private Properties props;//系统属性
    private boolean needAuth = false;//smtp是否需要认证

    private String username = "";//smtp认证的用户名密码
    private String password = "";

    private Multipart mp;//Multipart对象，邮件内容，标题，附件等内容均添加到其中

    public SendMail() {
        createMimeMessage();
    }

    public SendMail(String smtp) {

        setSmtpHost(smtp);
        createMimeMessage();
    }

    public void setSmtpHost(String hostName) {
        System.out.println("设置系统属性：mail.smtp.host" + hostName);
        if (props == null) props = System.getProperties();//获得系统属性对
        props.put("mail.smtp.host", hostName);//设置smtp主机
    }

    public boolean createMimeMessage() {
        try {
            System.out.println("准备获取邮件回话对象！");
            session = Session.getDefaultInstance(props, null);//获得邮件回话对象
        } catch (Exception e) {
            System.out.println("准备获取邮件回话对象错误！" + e);
            return false;
            // TODO: handle exception
        }

        System.out.println("准备创建MiMe邮件对象！");
        try {
            mimeMsg = new MimeMessage(mimeMsg);//创建mime邮件对象
            mp = new MimeMultipart();
            return true;
        } catch (Exception e) {
            System.out.println("准备创建MiMe邮件对象失败！" + e);
            return false;
            // TODO: handle exception
        }

    }

    public void setNeedAuth(boolean need) {
        System.out.println("设置smtp身份认证：mail.smtp.auth=");
        if (props == null) props = System.getProperties();

        if (need) {
            props.put("mail.smtp.auth", "true");
        }
        else {
            props.put("mail.smtp.auth", "false");
        }
    }


}
