package com.anyin.guwentong.bean.mybean;

import com.cp.mylibrary.bean.MyEntity;

import org.kymjs.kjframe.database.annotate.Id;

/**
 * Created by Jerry on 2016/8/18.
 * 我自己统一 的一套bean ，服务器上的bean来了之后，统一转换成我的这一套，
 * 代码中跑的完全是我自己的一套，因为服务器的不统一
 */
public class MyFundBean extends MyEntity {

    @Id()
    private String id;
    // 名称
    private String fundName;
    //    FundId	基金标号		基金编号
    private String fundId;


    //基金类型
    private String fundType;

    // 基金风险
    private String riskNumber;

    // 最小投资金额
    private String minValue;


    //七日年化收益
    private String qiRiNianHua;
  // 月涨跌幅
    private String yueZhangDieFu;
     private  String riZhangDieFu;

     // 净值
    private String zuiXinJinZhi;

    private String jiZhiDate;

     // 万份收益
     private  String wanFenShouYi;

    // 是否是货币基金 C代表是，N代表不是
    private String isCurrencyFund;

 //购买前费率		乘以100 + % 显示
    private String buyFeeBefore;
    //购买后费率		乘以100 + % 显示
    private String buyFeeAfter;
 //基金公司
    private String fundCompany;
    //今年涨跌幅		乘以100 + % 显示
    private String yearRate0;
    //	近一周涨跌幅		乘以100 + % 显示
    private String weekRate;
    private String monRate1;
    private String monRate3;
    private String yearRate1;
    private String yearRate3;

    private String yearRate0Bit;
    private String weekRateBit;
    private String monRate1Bit;

    private String monRate3Bit;

    private String yearRate1Bit;

    private String yearRate3Bit;
    //fundManager	基金经理
    private String fundManager;



    //是否可赎回字段		0不可赎回，1可赎回
    private String redeem;


    // 搜索关键字
    private String searchText;


    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public String getRiZhangDieFu() {
        return riZhangDieFu;
    }

    public void setRiZhangDieFu(String riZhangDieFu) {
        this.riZhangDieFu = riZhangDieFu;
    }

    public void setRiskNumber(String riskNumber) {
        this.riskNumber = riskNumber;
    }

    public String getJiZhiDate() {
        return jiZhiDate;
    }

    public void setJiZhiDate(String jiZhiDate) {
        this.jiZhiDate = jiZhiDate;
    }

    public String getBuyFeeBefore() {
        return buyFeeBefore;
    }

    public void setBuyFeeBefore(String buyFeeBefore) {
        this.buyFeeBefore = buyFeeBefore;
    }

    public String getBuyFeeAfter() {
        return buyFeeAfter;
    }

    public void setBuyFeeAfter(String buyFeeAfter) {
        this.buyFeeAfter = buyFeeAfter;
    }

    public String getFundCompany() {
        return fundCompany;
    }

    public void setFundCompany(String fundCompany) {
        this.fundCompany = fundCompany;
    }

    public String getYearRate0() {
        return yearRate0;
    }

    public void setYearRate0(String yearRate0) {
        this.yearRate0 = yearRate0;
    }

    public String getWeekRate() {
        return weekRate;
    }

    public void setWeekRate(String weekRate) {
        this.weekRate = weekRate;
    }

    public String getMonRate1() {
        return monRate1;
    }

    public void setMonRate1(String monRate1) {
        this.monRate1 = monRate1;
    }

    public String getMonRate3() {
        return monRate3;
    }

    public void setMonRate3(String monRate3) {
        this.monRate3 = monRate3;
    }

    public String getYearRate3() {
        return yearRate3;
    }

    public void setYearRate3(String yearRate3) {
        this.yearRate3 = yearRate3;
    }

    public String getYearRate0Bit() {
        return yearRate0Bit;
    }

    public void setYearRate0Bit(String yearRate0Bit) {
        this.yearRate0Bit = yearRate0Bit;
    }

    public String getWeekRateBit() {
        return weekRateBit;
    }

    public void setWeekRateBit(String weekRateBit) {
        this.weekRateBit = weekRateBit;
    }

    public String getMonRate1Bit() {
        return monRate1Bit;
    }

    public void setMonRate1Bit(String monRate1Bit) {
        this.monRate1Bit = monRate1Bit;
    }

    public String getMonRate3Bit() {
        return monRate3Bit;
    }

    public void setMonRate3Bit(String monRate3Bit) {
        this.monRate3Bit = monRate3Bit;
    }

    public String getYearRate1Bit() {
        return yearRate1Bit;
    }

    public void setYearRate1Bit(String yearRate1Bit) {
        this.yearRate1Bit = yearRate1Bit;
    }

    public String getYearRate3Bit() {
        return yearRate3Bit;
    }

    public void setYearRate3Bit(String yearRate3Bit) {
        this.yearRate3Bit = yearRate3Bit;
    }

    public String getFundManager() {
        return fundManager;
    }

    public void setFundManager(String fundManager) {
        this.fundManager = fundManager;
    }

    public String getRedeem() {
        return redeem;
    }

    public void setRedeem(String redeem) {
        this.redeem = redeem;
    }

    public String getWanFenShouYi() {
        return wanFenShouYi;
    }

    public void setWanFenShouYi(String wanFenShouYi) {
        this.wanFenShouYi = wanFenShouYi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public String getFundType() {
        return fundType;
    }

    public void setFundType(String fundType) {
        this.fundType = fundType;
    }


    public String getRiskNumber() {
        return riskNumber;
    }



    public String getMinValue() {
        return minValue;
    }

    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    public String getYearRate1() {
        return yearRate1;
    }

    public void setYearRate1(String yearRate1) {
        this.yearRate1 = yearRate1;
    }

    public String getQiRiNianHua() {
        return qiRiNianHua;
    }

    public void setQiRiNianHua(String qiRiNianHua) {
        this.qiRiNianHua = qiRiNianHua;
    }

    public String getYueZhangDieFu() {
        return yueZhangDieFu;
    }

    public void setYueZhangDieFu(String yueZhangDieFu) {
        this.yueZhangDieFu = yueZhangDieFu;
    }

    public String getZuiXinJinZhi() {
        return zuiXinJinZhi;
    }

    public void setZuiXinJinZhi(String zuiXinJinZhi) {
        this.zuiXinJinZhi = zuiXinJinZhi;
    }

    public String getIsCurrencyFund() {
        return isCurrencyFund;
    }

    public void setIsCurrencyFund(String isCurrencyFund) {
        this.isCurrencyFund = isCurrencyFund;
    }
}
