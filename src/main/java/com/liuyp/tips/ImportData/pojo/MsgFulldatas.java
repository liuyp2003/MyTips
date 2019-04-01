package com.liuyp.tips.ImportData.pojo;

import com.vdurmont.emoji.EmojiParser;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 和飞信安全信息-全量表 svc_msg_fulldatas
 *
 * @author feinno
 * @date 2018-08-21
 */
public class MsgFulldatas {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(MsgFulldatas.class);

    /** md5_发送方id_发送时间_uuid */
    private String md5SendidSendtimeUuid;
    /** 分类结果 */
    private Integer classify;
    /** 文本消息内容 */
    private String txtContent;
    /** 消息内容长度 */
    private Integer txtContentLen;
    /** 0_全部1_文本2_图片3_音频4_视频5_文件6_网址13_二人转短14_超级短信15_超级短信16_群陌生人交换名片17_群主短信
     18_群邀请短信19_中兴运营活动调用20_中兴营销活动21_中兴行业短信业务 22_ott系统短信23_超级短信24_转短文本
     25_彩云分享26_转短图片27_联系人名片28_语音消息29_视频消息30_地理位置31_未知类型文件 */
    private Integer msgType;
    /**  */
    private Integer credit;
    /** 所有附件的路径，带文件后缀 */
    private String filePath;
    /** 消息流经的策略32位bit转成的整数从右侧开始计数 1表示流经该策略）1关键词策略 2指纹策略 3人工审核结果指纹 4用户频次策略 5人工审核结果 6富媒体策略 7应急管控 8黑名单 9热点送审策略 10黑指纹策略 11白指纹 12人工审核临时黑指纹 13人工审核临时白指纹 14黑名单生成策略 20业管一级关键词 21业管黑名单 22业管白名单 23业管用户分级频次 24业管群黑名单 */
    private String filterPath;
    /** 消息过滤结果1未中策略放行 2放行 3先发后审（遗弃） 4先审后发（疑似送审） 5拦截不送审 6拦截送审 7拦截加黑送审（现在不送审了） */
    private Integer filterResult;
    /** 是否命中黑指纹： 0、未命中 1、命中 */
    private Integer fingerprintType;
    /** 拦截次数 该字段无用 */
    private Integer intercept;
    /** 消息的MD5 */
    private String msgMd5;
    /** 发送时间 */
    private Long msgdate;
    /** 消息的ID */
    private String msgId;
    /** 命中策略详情 */
    private String policyDetail;
    /** 命中策略ID */
    private String policyId;
    /** 命中策略的类型，0_未命中关键词策略2_指纹策略3_指纹策略4_用户分级频次策略5_人工审核结果6_富媒体策略7_应急管控
     8_黑名单9_热点送审10_黑指纹策略11_白指纹12_临时黑指纹13_临时白指纹14_黑名单生成策略15_发收比策略20_业管一级关键词21_业管黑名单
     22_业管白名单23_业管用户分级频次25_群黑名单26_发收比行为策略27_转短频次行为策略28_相似内容行为策略29_扇度行为策略30_红名单用户行为策略 */
    private Integer policyType;
    /** 接收方手机号  群聊消息：群ID  群发消息：多个接收方手机号（多个接收方以逗号分隔） */
    private String revcId;
    /** 该消息计算的发送次数（点对点为1，群发为revcId个数） */
    private Integer sendCount;
    /** 发送方手机号 */
    private String sendId;
    /** 业务类型0_全部1_点对点2_群发3_群聊4_圈子5_Profile6_公众号7_小组8_公众号点对点9_和多号10_转短消息11_群名称12_群昵称
     */
    private Integer svcType;
    /** 端口号 */
    private String smsport;
    /** 是否命中监控  8：命中 */
    private String monitorrst;
    /** 命中的监控策略类型，"26"-"发收比行为策略""27"-"转短频次行为策略""28"-"相似内容行为策略-柔性指纹""29"-"扇度行为策略"
     "30"-"红名单用户行为策略""31"-"名称修改行为策略""32"-"转短消息限额配置""33"-"相似内容行为策略-账号""34"-"登录IP行为策略"
     "35"-"IP发送量异常行为策略""36"-"相似内容行为策略-IP""37"-"陌生人消息占比策略""38"-"举报行为策略""39"-"设备行为策略"
     类型通策略类型字段
     */
    private String monitortype;
    /** 命中的监控策略id */
    private String monitorid;
    /** 好友关系  0：陌生人  1：好友，与接收方号码一一对应 */
    private String friend;
    /** ip地址 */
    private String ipAddr;
    /** 版本号 */
    private String version;
    /** 设备码 */
    private String deviceCode;
    /** 基站码 */
    private String cellId;
    /** 陌生人数 */
    private String strangerCount;
    /** 总接收方人数 */
    private Integer totalCount;
    //第二个指纹
    private Integer secmd5;
    //业务接入方的tokenId
    private Integer tokenid;
    //是否在免审名单中，0－不在免审；1－免审
    private Integer noaudittype;
    //人工审核结果 3合规，4违规；
    private Integer auditresult;
    //人工审核消息分类
    private String auditclassify;

    /**
     * 设置：md5_发送方id_发送时间_uuid
     */
    public void setMd5SendidSendtimeUuid(String md5SendidSendtimeUuid)
    {
        this.md5SendidSendtimeUuid = md5SendidSendtimeUuid;
    }

    /**
     * 获取：md5_发送方id_发送时间_uuid
     */
    public String getMd5SendidSendtimeUuid()
    {
        return md5SendidSendtimeUuid;
    }

    /**
     * 设置：分类结果
     */
    public void setClassify(Integer classify)
    {
        this.classify = classify;
    }

    /**
     * 获取：分类结果
     */
    public Integer getClassify()
    {
        return classify;
    }

    /**
     * 设置：文本消息内容
     */
    public void setTxtContent(String txtContent)
    {
        this.txtContent = txtContent;
    }

    /**
     * 获取：文本消息内容
     */
    public String getTxtContent()
    {
        return txtContent;
    }

    /**
     * 设置：消息内容长度
     */
    public void setTxtContentLen(Integer txtContentLen)
    {
        this.txtContentLen = txtContentLen;
    }

    /**
     * 获取：消息内容长度
     */
    public Integer getTxtContentLen()
    {
        return txtContentLen;
    }

    /**
     * 设置：0_全部
     1_文本
     2_图片
     3_音频
     4_视频
     5_文件
     6_网址
     13_二人转短
     14_超级短信
     15_超级短信
     16_群陌生人交换名片
     17_群主短信
     18_群邀请短信
     19_中兴运营活动调用
     20_中兴营销活动
     21_中兴行业短信业务
     22_ott系统短信
     23_超级短信
     24_转短文本
     25_彩云分享
     26_转短图片
     27_联系人名片
     28_语音消息
     29_视频消息
     30_地理位置
     31_未知类型文件
     */
    public void setMsgType(Integer msgType)
    {
        this.msgType = msgType;
    }

    /**
     * 获取：0_全部
     1_文本
     2_图片
     3_音频
     4_视频
     5_文件
     6_网址
     13_二人转短
     14_超级短信
     15_超级短信
     16_群陌生人交换名片
     17_群主短信
     18_群邀请短信
     19_中兴运营活动调用
     20_中兴营销活动
     21_中兴行业短信业务
     22_ott系统短信
     23_超级短信
     24_转短文本
     25_彩云分享
     26_转短图片
     27_联系人名片
     28_语音消息
     29_视频消息
     30_地理位置
     31_未知类型文件
     */
    public Integer getMsgType()
    {
        return msgType;
    }

    /**
     * 设置：
     */
    public void setCredit(Integer credit)
    {
        this.credit = credit;
    }

    /**
     * 获取：
     */
    public Integer getCredit()
    {
        return credit;
    }

    /**
     * 设置：所有附件的路径，带文件后缀
     */
    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }

    /**
     * 获取：所有附件的路径，带文件后缀
     */
    public String getFilePath()
    {
        return filePath;
    }

    /**
     * 设置：消息流经的策略32位bit转成的整数从右侧开始计数 1表示流经该策略）1关键词策略 2指纹策略 3人工审核结果指纹 4用户频次策略 5人工审核结果 6富媒体策略 7应急管控 8黑名单 9热点送审策略 10黑指纹策略 11白指纹 12人工审核临时黑指纹 13人工审核临时白指纹 14黑名单生成策略 20业管一级关键词 21业管黑名单 22业管白名单 23业管用户分级频次 24业管群黑名单
     */
    public void setFilterPath(String filterPath)
    {
        this.filterPath = filterPath;
    }

    /**
     * 获取：消息流经的策略32位bit转成的整数从右侧开始计数 1表示流经该策略）1关键词策略 2指纹策略 3人工审核结果指纹 4用户频次策略 5人工审核结果 6富媒体策略 7应急管控 8黑名单 9热点送审策略 10黑指纹策略 11白指纹 12人工审核临时黑指纹 13人工审核临时白指纹 14黑名单生成策略 20业管一级关键词 21业管黑名单 22业管白名单 23业管用户分级频次 24业管群黑名单
     */
    public String getFilterPath()
    {
        return filterPath;
    }

    /**
     * 设置：消息过滤结果1未中策略放行 2放行 3先发后审（遗弃） 4先审后发（疑似送审） 5拦截不送审 6拦截送审 7拦截加黑送审（现在不送审了）
     */
    public void setFilterResult(Integer filterResult)
    {
        this.filterResult = filterResult;
    }

    /**
     * 获取：消息过滤结果1未中策略放行 2放行 3先发后审（遗弃） 4先审后发（疑似送审） 5拦截不送审 6拦截送审 7拦截加黑送审（现在不送审了）
     */
    public Integer getFilterResult()
    {
        return filterResult;
    }

    /**
     * 设置：是否命中黑指纹： 0、未命中 1、命中
     */
    public void setFingerprintType(Integer fingerprintType)
    {
        this.fingerprintType = fingerprintType;
    }

    /**
     * 获取：是否命中黑指纹： 0、未命中 1、命中
     */
    public Integer getFingerprintType()
    {
        return fingerprintType;
    }

    /**
     * 设置：拦截次数 该字段无用
     */
    public void setIntercept(Integer intercept)
    {
        this.intercept = intercept;
    }

    /**
     * 获取：拦截次数 该字段无用
     */
    public Integer getIntercept()
    {
        return intercept;
    }

    /**
     * 设置：消息的MD5
     */
    public void setMsgMd5(String msgMd5)
    {
        this.msgMd5 = msgMd5;
    }

    /**
     * 获取：消息的MD5
     */
    public String getMsgMd5()
    {
        return msgMd5;
    }

    /**
     * 设置：发送时间
     */
    public void setMsgdate(Long msgdate)
    {
        this.msgdate = msgdate;
    }

    /**
     * 获取：发送时间
     */
    public Long getMsgdate()
    {
        return msgdate;
    }

    /**
     * 设置：消息的ID
     */
    public void setMsgId(String msgId)
    {
        this.msgId = msgId;
    }

    /**
     * 获取：消息的ID
     */
    public String getMsgId()
    {
        return msgId;
    }

    /**
     * 设置：命中策略详情
     */
    public void setPolicyDetail(String policyDetail)
    {
        this.policyDetail = policyDetail;
    }

    /**
     * 获取：命中策略详情
     */
    public String getPolicyDetail()
    {
        return policyDetail;
    }

    /**
     * 设置：命中策略ID
     */
    public void setPolicyId(String policyId)
    {
        this.policyId = policyId;
    }

    /**
     * 获取：命中策略ID
     */
    public String getPolicyId()
    {
        return policyId;
    }

    /**
     * 设置：命中策略的类型，
     0_未命中策略
     1_关键词策略
     2_指纹策略
     3_指纹策略
     4_用户分级频次策略
     5_人工审核结果
     6_富媒体策略
     7_应急管控
     8_黑名单
     9_热点送审
     10_黑指纹策略
     11_白指纹
     12_临时黑指纹
     13_临时白指纹
     14_黑名单生成策略
     15_发收比策略
     20_业管一级关键词
     21_业管黑名单
     22_业管白名单
     23_业管用户分级频次
     25_群黑名单
     26_发收比行为策略
     27_转短频次行为策略
     28_相似内容行为策略
     29_扇度行为策略
     30_红名单用户行为策略
     */
    public void setPolicyType(Integer policyType)
    {
        this.policyType = policyType;
    }

    /**
     * 获取：命中策略的类型，
     0_未命中策略
     1_关键词策略
     2_指纹策略
     3_指纹策略
     4_用户分级频次策略
     5_人工审核结果
     6_富媒体策略
     7_应急管控
     8_黑名单
     9_热点送审
     10_黑指纹策略
     11_白指纹
     12_临时黑指纹
     13_临时白指纹
     14_黑名单生成策略
     15_发收比策略
     20_业管一级关键词
     21_业管黑名单
     22_业管白名单
     23_业管用户分级频次
     25_群黑名单
     26_发收比行为策略
     27_转短频次行为策略
     28_相似内容行为策略
     29_扇度行为策略
     30_红名单用户行为策略
     */
    public Integer getPolicyType()
    {
        return policyType;
    }

    /**
     * 设置：接收方手机号  群聊消息：群ID  群发消息：多个接收方手机号（多个接收方以逗号分隔）
     */
    public void setRevcId(String revcId)
    {
        this.revcId = revcId;
    }

    /**
     * 获取：接收方手机号  群聊消息：群ID  群发消息：多个接收方手机号（多个接收方以逗号分隔）
     */
    public String getRevcId()
    {
        return revcId;
    }

    /**
     * 设置：该消息计算的发送次数（点对点为1，群发为revcId个数）
     */
    public void setSendCount(Integer sendCount)
    {
        this.sendCount = sendCount;
    }

    /**
     * 获取：该消息计算的发送次数（点对点为1，群发为revcId个数）
     */
    public Integer getSendCount()
    {
        return sendCount;
    }

    /**
     * 设置：发送方手机号
     */
    public void setSendId(String sendId)
    {
        this.sendId = sendId;
    }

    /**
     * 获取：发送方手机号
     */
    public String getSendId()
    {
        return sendId;
    }

    /**
     * 设置：业务类型
     0_全部
     1_点对点
     2_群发
     3_群聊
     4_圈子
     5_Profile
     6_公众号
     7_小组
     8_公众号点对点
     9_和多号
     10_转短消息
     11_群名称
     12_群昵称

     */
    public void setSvcType(Integer svcType)
    {
        this.svcType = svcType;
    }

    /**
     * 获取：业务类型
     0_全部
     1_点对点
     2_群发
     3_群聊
     4_圈子
     5_Profile
     6_公众号
     7_小组
     8_公众号点对点
     9_和多号
     10_转短消息
     11_群名称
     12_群昵称

     */
    public Integer getSvcType()
    {
        return svcType;
    }

    /**
     * 设置：端口号
     */
    public void setSmsport(String smsport)
    {
        this.smsport = smsport;
    }

    /**
     * 获取：端口号
     */
    public String getSmsport()
    {
        return smsport;
    }

    /**
     * 设置：是否命中监控  8：命中
     */
    public void setMonitorrst(String monitorrst)
    {
        this.monitorrst = monitorrst;
    }

    /**
     * 获取：是否命中监控  8：命中
     */
    public String getMonitorrst()
    {
        return monitorrst;
    }

    /**
     * 设置：命中的监控策略类型，
     "26"-"发收比行为策略"
     "27"-"转短频次行为策略"
     "28"-"相似内容行为策略-柔性指纹"
     "29"-"扇度行为策略"
     "30"-"红名单用户行为策略"
     "31"-"名称修改行为策略"
     "32"-"转短消息限额配置"
     "33"-"相似内容行为策略-账号"
     "34"-"登录IP行为策略"
     "35"-"IP发送量异常行为策略"
     "36"-"相似内容行为策略-IP"
     "37"-"陌生人消息占比策略"
     "38"-"举报行为策略"
     "39"-"设备行为策略"
     类型通策略类型字段

     */
    public void setMonitortype(String monitortype)
    {
        this.monitortype = monitortype;
    }

    /**
     * 获取：命中的监控策略类型，
     "26"-"发收比行为策略"
     "27"-"转短频次行为策略"
     "28"-"相似内容行为策略-柔性指纹"
     "29"-"扇度行为策略"
     "30"-"红名单用户行为策略"
     "31"-"名称修改行为策略"
     "32"-"转短消息限额配置"
     "33"-"相似内容行为策略-账号"
     "34"-"登录IP行为策略"
     "35"-"IP发送量异常行为策略"
     "36"-"相似内容行为策略-IP"
     "37"-"陌生人消息占比策略"
     "38"-"举报行为策略"
     "39"-"设备行为策略"
     类型通策略类型字段

     */
    public String getMonitortype()
    {
        return monitortype;
    }

    /**
     * 设置：命中的监控策略id
     */
    public void setMonitorid(String monitorid)
    {
        this.monitorid = monitorid;
    }

    /**
     * 获取：命中的监控策略id
     */
    public String getMonitorid()
    {
        return monitorid;
    }

    /**
     * 设置：好友关系  0：陌生人  1：好友，与接收方号码一一对应
     */
    public void setFriend(String friend)
    {
        this.friend = friend;
    }

    /**
     * 获取：好友关系  0：陌生人  1：好友，与接收方号码一一对应
     */
    public String getFriend()
    {
        return friend;
    }

    /**
     * 设置：ip地址
     */
    public void setIpAddr(String ipAddr)
    {
        this.ipAddr = ipAddr;
    }

    /**
     * 获取：ip地址
     */
    public String getIpAddr()
    {
        return ipAddr;
    }

    /**
     * 设置：版本号
     */
    public void setVersion(String version)
    {
        this.version = version;
    }

    /**
     * 获取：版本号
     */
    public String getVersion()
    {
        return version;
    }

    /**
     * 设置：设备码
     */
    public void setDeviceCode(String deviceCode)
    {
        this.deviceCode = deviceCode;
    }

    /**
     * 获取：设备码
     */
    public String getDeviceCode()
    {
        return deviceCode;
    }

    /**
     * 设置：基站码
     */
    public void setCellId(String cellId)
    {
        this.cellId = cellId;
    }

    /**
     * 获取：基站码
     */
    public String getCellId()
    {
        return cellId;
    }

    /**
     * 设置：陌生人数
     */
    public void setStrangerCount(String strangerCount)
    {
        this.strangerCount = strangerCount;
    }

    /**
     * 获取：陌生人数
     */
    public String getStrangerCount()
    {
        return strangerCount;
    }

    /**
     * 设置：总接收方人数
     */
    public void setTotalCount(Integer totalCount)
    {
        this.totalCount = totalCount;
    }

    /**
     * 获取：总接收方人数
     */
    public Integer getTotalCount()
    {
        return totalCount;
    }

    public Integer getSecmd5() {
        return secmd5;
    }

    public void setSecmd5(Integer secmd5) {
        this.secmd5 = secmd5;
    }

    public Integer getTokenid() {
        return tokenid;
    }

    public void setTokenid(Integer tokenid) {
        this.tokenid = tokenid;
    }

    public Integer getNoaudittype() {
        return noaudittype;
    }

    public void setNoaudittype(Integer noaudittype) {
        this.noaudittype = noaudittype;
    }

    public Integer getAuditresult() {
        return auditresult;
    }

    public void setAuditresult(Integer auditresult) {
        this.auditresult = auditresult;
    }

    public String getAuditclassify() {
        return auditclassify;
    }

    public void setAuditclassify(String auditclassify) {
        this.auditclassify = auditclassify;
    }

    public MsgFulldatas(){

    }
    public MsgFulldatas(String[] args) {
        if(args[0].length() > 255){
            logger.warn("Md5SendidSendtimeUuid:"+args[0]);
            this.setMd5SendidSendtimeUuid(args[0].substring(0,254));
        }else{
            this.setMd5SendidSendtimeUuid(args[0]);
        }
        this.setClassify(Integer.parseInt(args[1]));
        this.setTxtContent(EmojiParser.removeAllEmojis(args[2]));
        this.setTxtContentLen(Integer.parseInt(args[3]));
        this.setMsgType(Integer.parseInt(args[4]));
        this.setCredit(Integer.parseInt(args[5]));
        if(args[6].length() > 254){
            logger.warn("FilePath:"+args[6]);
            this.setFilePath(args[6].substring(0,254));
        }else{
            this.setFilePath(args[6]);
        }
        if(args[7].length() > 254){
            logger.warn("FilterPath:"+args[7]);
            this.setFilterPath(args[7].substring(0,254));
        }else{
            this.setFilterPath(args[7]);
        }
        this.setFilterResult(Integer.parseInt(args[8]));
        this.setFingerprintType(Integer.parseInt(args[9]));
        this.setIntercept(Integer.parseInt(args[10]));
        if(args[11].length() > 254){
            logger.warn("MsgMd5:"+args[11]);
            this.setMsgMd5(args[11].substring(0,254));
        }else{
            this.setMsgMd5(args[11]);
        }
        this.setMsgdate(Long.parseLong(args[12]));
        if(args[13].length() > 254){
            logger.warn("MsgId:"+args[13]);
            this.setMsgId(args[13].substring(0,254));
        }else{
            this.setMsgId(args[13]);
        }
        if(args[14].length() > 254){
            logger.warn("PolicyDetail:"+args[14]);
            this.setPolicyDetail(args[14].substring(0,254));
        }else{
            this.setPolicyDetail(args[14]);
        }
        this.setPolicyId(args[15]);
        this.setPolicyType(Integer.parseInt(args[16]));
        this.setRevcId(args[17]);
        this.setSendCount(Integer.parseInt(args[18]));
        if(StringUtils.isNotEmpty(args[19]) && StringUtils.isNumeric(args[19])){
            this.setSendId(args[19]);
        }else{
            this.setSendId("11111111111");
        }
        this.setSvcType(Integer.parseInt(args[20]));
        this.setSmsport(args[21]);
        this.setMonitorrst(args[22]);
        this.setMonitortype(args[23]);
        this.setMonitorid(args[24]);
        this.setFriend(args[25]);
        this.setIpAddr(args[26]);
        this.setVersion(args[27]);
        if(args[28].length() > 254){
            logger.warn("DeviceCode:"+args[28]);
            this.setDeviceCode(args[28].substring(0,254));
        }else{
            this.setDeviceCode(args[28]);
        }
        if(args[29].length() > 200){
            logger.warn("CellId:"+args[29]);
            this.setCellId(args[29].substring(0,199));
        }else{
            this.setCellId(args[29]);
        }
        this.setStrangerCount(args[30]);
        this.setTotalCount(Integer.parseInt(args[31]));
        if(StringUtils.isNotEmpty(args[32])){
            logger.warn("Secmd5:"+args[32]);
            this.setSecmd5(Integer.parseInt(args[32]));
        }else{
            this.setSecmd5(0);
        }
        if(StringUtils.isNotEmpty(args[33])){
            this.setTokenid(Integer.parseInt(args[33]));
        }else{
            this.setTokenid(0);
        }
        if(StringUtils.isNotEmpty(args[34])){
            this.setNoaudittype(Integer.parseInt(args[34]));
        }else{
            this.setNoaudittype(0);
        }
        if(StringUtils.isNotEmpty(args[35])){
            this.setAuditresult(Integer.parseInt(args[35]));
        }else{
            this.setAuditresult(0);
        }

        if(args[36].length() > 254){
            logger.warn("Auditclassify:"+args[36]);
            this.setAuditclassify(args[36].substring(0,254));
        }else{
            this.setAuditclassify(args[36]);
        }
     }

    public MsgFulldatas(MsgFulldatas ml) {
        if(ml.getMd5SendidSendtimeUuid().length() > 255){
            logger.warn("Md5SendidSendtimeUuid:"+ml.getMd5SendidSendtimeUuid());
            this.setMd5SendidSendtimeUuid(ml.getMd5SendidSendtimeUuid().substring(0,254));
        }else{
            this.setMd5SendidSendtimeUuid(ml.getMd5SendidSendtimeUuid());
        }
        this.setClassify(ml.getClassify());
        this.setTxtContentLen(ml.getTxtContentLen());
        this.setMsgType(ml.getMsgType());
        this.setCredit(ml.getCredit());
        if(ml.getFilePath().length() > 254){
            logger.warn("FilePath:"+ml.getFilePath());
            this.setFilePath(ml.getFilePath().substring(0,254));
        }else{
            this.setFilePath(ml.getFilePath());
        }
        if(ml.getFilterPath().length() > 254){
            logger.warn("FilterPath:"+ml.getFilterPath());
            this.setFilterPath(ml.getFilterPath().substring(0,254));
        }else{
            this.setFilterPath(ml.getFilterPath());
        }
        this.setFilterResult(ml.getFilterResult());
        this.setFingerprintType(ml.getFingerprintType());
        this.setIntercept(ml.getIntercept());
        if(ml.getMsgMd5().length() > 254){
            logger.warn("MsgMd5:"+ml.getMsgMd5());
            this.setMsgMd5(ml.getMsgMd5().substring(0,254));
        }else{
            this.setMsgMd5(ml.getMsgMd5());
        }
        this.setMsgdate(ml.getMsgdate());
        if(ml.getMsgId().length() > 254){
            logger.warn("MsgId:"+ml.getMsgId());
            this.setMsgId(ml.getMsgId().substring(0,254));
        }else{
            this.setMsgId(ml.getMsgId());
        }
        if(ml.getPolicyDetail().length() > 254){
            logger.warn("PolicyDetail:"+ml.getPolicyDetail());
            this.setPolicyDetail(ml.getPolicyDetail().substring(0,254));
        }else{
            this.setPolicyDetail(ml.getPolicyDetail());
        }
        this.setPolicyId(ml.getPolicyId());
        this.setPolicyType(ml.getPolicyType());
        this.setRevcId(ml.getRevcId());
        this.setSendCount(ml.getSendCount());
        if(StringUtils.isNotEmpty(ml.getSendId()) && StringUtils.isNumeric(ml.getSendId())){
            this.setSendId(ml.getSendId());
        }else{
            this.setSendId("11111111111");
        }
        this.setSvcType(ml.getSvcType());
        this.setSmsport(ml.getSmsport());
        this.setMonitorrst(ml.getMonitorrst());
        this.setMonitortype(ml.getMonitortype());
        this.setMonitorid(ml.getMonitorid());
        this.setFriend(ml.getFriend());
        this.setIpAddr(ml.getIpAddr());
        this.setVersion(ml.getVersion());
        if(ml.getDeviceCode().length() > 254){
            logger.warn("DeviceCode:"+ml.getDeviceCode());
            this.setDeviceCode(ml.getDeviceCode().substring(0,254));
        }else{
            this.setDeviceCode(ml.getDeviceCode());
        }
        if(ml.getCellId().length() > 200){
            logger.warn("CellId:"+ml.getCellId());
            this.setCellId(ml.getCellId().substring(0,199));
        }else{
            this.setCellId(ml.getCellId());
        }
        this.setStrangerCount(ml.getStrangerCount());
        this.setTotalCount(ml.getTotalCount());
        this.setSecmd5(ml.getSecmd5());
        this.setTokenid(ml.getTokenid());
        this.setNoaudittype(ml.getNoaudittype());
        this.setAuditresult(ml.getAuditresult());

        if(ml.getAuditclassify().length() > 254){
            logger.warn("Auditclassify:"+ml.getAuditclassify());
            this.setAuditclassify(ml.getAuditclassify().substring(0,254));
        }else{
            this.setAuditclassify(ml.getAuditclassify());
        }
    }

    @Override
    public String toString() {
        return "MsgFulldatasDay{" +
                "md5SendidSendtimeUuid='" + md5SendidSendtimeUuid + '\'' +
                ", classify=" + classify +
                ", txtContentLen=" + txtContentLen +
                ", msgType=" + msgType +
                ", credit=" + credit +
                ", filePath='" + filePath + '\'' +
                ", filterPath='" + filterPath + '\'' +
                ", filterResult=" + filterResult +
                ", fingerprintType=" + fingerprintType +
                ", intercept=" + intercept +
                ", msgMd5='" + msgMd5 + '\'' +
                ", msgdate=" + msgdate +
                ", msgId='" + msgId + '\'' +
                ", policyDetail='" + policyDetail + '\'' +
                ", policyId='" + policyId + '\'' +
                ", policyType=" + policyType +
                ", revcId='" + revcId + '\'' +
                ", sendCount=" + sendCount +
                ", sendId='" + sendId + '\'' +
                ", svcType=" + svcType +
                ", smsport='" + smsport + '\'' +
                ", monitorrst='" + monitorrst + '\'' +
                ", monitortype='" + monitortype + '\'' +
                ", monitorid='" + monitorid + '\'' +
                ", friend='" + friend + '\'' +
                ", ipAddr='" + ipAddr + '\'' +
                ", version='" + version + '\'' +
                ", deviceCode='" + deviceCode + '\'' +
                ", cellId='" + cellId + '\'' +
                ", strangerCount='" + strangerCount + '\'' +
                ", totalCount=" + totalCount +
                ", secmd5=" + secmd5 +
                ", tokenid=" + tokenid +
                ", noaudittype=" + noaudittype +
                ", auditresult=" + auditresult +
                ", auditclassify='" + auditclassify + '\'' +
                '}';
    }
}
