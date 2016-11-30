package com.anyin.guwentong.bean.responbean;


import org.kymjs.kjframe.database.annotate.Id;

/**
 * 用户信息
 *
 * @author Administrator
 *         <p/>
 *         <p/>
 *         {"nickName":"","headImage":"","userId":"02e2a1348a2b4b62b71719af151294ad"}
 */


public class User {

    /**
     * 每个实体中都 要有的属性，id ,kjDB,往数据库里存的时候拿不到父类的
     */

    // 将id属性设置为主键，必须有一个主键，
    // 其实如果变量名为：'id'或'_id'默认就是主键
    // 也就是在一个JavaBean里面必须有'id'或'_id'或'@Id()'注解，否则会报错
    @Id()
    private int id;


    public String userId;


    // 手机号
    private String userPhone;

    // 头像
    private String headImage;

    // 昵称
    private String nickName;

    private String bornDate;

    // 性别,1=男，2=女
    private int sex;

    //地址
    private String address;
    // 积分
    private String integral;
    //
    private  String userEmail;


    private  String memberUrl;

     private  String memberRating;


    public String getMemberRating() {
        return memberRating;
    }

    public void setMemberRating(String memberRating) {
        this.memberRating = memberRating;
    }

    public String getMemberUrl() {
        return memberUrl;
    }

    public void setMemberUrl(String memberUrl) {
        this.memberUrl = memberUrl;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }

    public String getAddress() {

//        if(StringUtils.isEmpty(address))
//                return "广东 广州";
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getHeadImage() {

//        if(StringUtils.isEmpty(headImage))
//            return "ali";
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public String getNickName() {
//        if(StringUtils.isEmpty(nickName))
//            return "爱理不理";
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getBornDate() {
//        if(StringUtils.isEmpty(bornDate))
//            return "1995-06-21";
        return bornDate;
    }

    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }
}
