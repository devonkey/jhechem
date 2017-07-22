package top.jhechem.order.pojo;

import cn.idongjia.common.base.Base;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * 订单
 * Created by wuqiang on 2017/7/20.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order extends Base {

    private Long bookid;
    private Integer paixu;
    private String casno;
    private String bookname;
    private String enbookname;
    private String ordernum;
    private String fapiaonum;
    private String krname;
    private Long date1;
    private Long date2;
    private Integer cjsl;
    private String style;
    private String price1;
    private String price2;
    private String ysfs;
    private String ysfy;
    private String hl;
    private String zsh;
    private String huokuan;
    private String lirun;
    private String yundan;
    private Long date3;
    private Integer cpgg;
    private String baozhuang;
    private String isyp;
    private String gyscontact;
    private String gysname;
    private String iskucun;
    private Integer kucun;
    private String fj1;
    private String fj2;
    private String ywy;
    private Boolean isjs;
    private Boolean isdh;
    private Boolean isfh;
    private Boolean isfp;
    private Boolean isfxbg;
    private String zhfrom;
    private Boolean ists;
    private Long date4;
    private Boolean issh;
    private Boolean iskp;
    private Boolean isgcfp;
    private Integer mylx;
    private Boolean ishx;
    private Long date5;
    private Boolean iswcts;
    private Boolean ishkqf;
    private String qgchk;
    private String krqk;
    private Boolean isok;
    private String krkpdz;
    private String krfhdz;
    private String content;

    public Long getBookid() {
        return bookid;
    }

    public void setBookid(Long bookid) {
        this.bookid = bookid;
    }

    public Integer getPaixu() {
        return paixu;
    }

    public void setPaixu(Integer paixu) {
        this.paixu = paixu;
    }

    public String getCasno() {
        return casno;
    }

    public void setCasno(String casno) {
        this.casno = casno;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getEnbookname() {
        return enbookname;
    }

    public void setEnbookname(String enbookname) {
        this.enbookname = enbookname;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }

    public String getFapiaonum() {
        return fapiaonum;
    }

    public void setFapiaonum(String fapiaonum) {
        this.fapiaonum = fapiaonum;
    }

    public String getKrname() {
        return krname;
    }

    public void setKrname(String krname) {
        this.krname = krname;
    }

    public Long getDate1() {
        return date1;
    }

    public void setDate1(Long date1) {
        this.date1 = date1;
    }

    public Long getDate2() {
        return date2;
    }

    public void setDate2(Long date2) {
        this.date2 = date2;
    }

    public Integer getCjsl() {
        return cjsl;
    }

    public void setCjsl(Integer cjsl) {
        this.cjsl = cjsl;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getPrice1() {
        return price1;
    }

    public void setPrice1(String price1) {
        this.price1 = price1;
    }

    public String getPrice2() {
        return price2;
    }

    public void setPrice2(String price2) {
        this.price2 = price2;
    }

    public String getYsfs() {
        return ysfs;
    }

    public void setYsfs(String ysfs) {
        this.ysfs = ysfs;
    }

    public String getYsfy() {
        return ysfy;
    }

    public void setYsfy(String ysfy) {
        this.ysfy = ysfy;
    }

    public String getHl() {
        return hl;
    }

    public void setHl(String hl) {
        this.hl = hl;
    }

    public String getZsh() {
        return zsh;
    }

    public void setZsh(String zsh) {
        this.zsh = zsh;
    }

    public String getHuokuan() {
        return huokuan;
    }

    public void setHuokuan(String huokuan) {
        this.huokuan = huokuan;
    }

    public String getLirun() {
        return lirun;
    }

    public void setLirun(String lirun) {
        this.lirun = lirun;
    }

    public String getYundan() {
        return yundan;
    }

    public void setYundan(String yundan) {
        this.yundan = yundan;
    }

    public Long getDate3() {
        return date3;
    }

    public void setDate3(Long date3) {
        this.date3 = date3;
    }

    public Integer getCpgg() {
        return cpgg;
    }

    public void setCpgg(Integer cpgg) {
        this.cpgg = cpgg;
    }

    public String getBaozhuang() {
        return baozhuang;
    }

    public void setBaozhuang(String baozhuang) {
        this.baozhuang = baozhuang;
    }

    public String getIsyp() {
        return isyp;
    }

    public void setIsyp(String isyp) {
        this.isyp = isyp;
    }

    public String getGyscontact() {
        return gyscontact;
    }

    public void setGyscontact(String gyscontact) {
        this.gyscontact = gyscontact;
    }

    public String getGysname() {
        return gysname;
    }

    public void setGysname(String gysname) {
        this.gysname = gysname;
    }

    public String getIskucun() {
        return iskucun;
    }

    public void setIskucun(String iskucun) {
        this.iskucun = iskucun;
    }

    public Integer getKucun() {
        return kucun;
    }

    public void setKucun(Integer kucun) {
        this.kucun = kucun;
    }

    public String getFj1() {
        return fj1;
    }

    public void setFj1(String fj1) {
        this.fj1 = fj1;
    }

    public String getFj2() {
        return fj2;
    }

    public void setFj2(String fj2) {
        this.fj2 = fj2;
    }

    public String getYwy() {
        return ywy;
    }

    public void setYwy(String ywy) {
        this.ywy = ywy;
    }

    public Boolean getIsjs() {
        return isjs;
    }

    public void setIsjs(Boolean isjs) {
        this.isjs = isjs;
    }

    public Boolean getIsdh() {
        return isdh;
    }

    public void setIsdh(Boolean isdh) {
        this.isdh = isdh;
    }

    public Boolean getIsfh() {
        return isfh;
    }

    public void setIsfh(Boolean isfh) {
        this.isfh = isfh;
    }

    public Boolean getIsfp() {
        return isfp;
    }

    public void setIsfp(Boolean isfp) {
        this.isfp = isfp;
    }

    public Boolean getIsfxbg() {
        return isfxbg;
    }

    public void setIsfxbg(Boolean isfxbg) {
        this.isfxbg = isfxbg;
    }

    public String getZhfrom() {
        return zhfrom;
    }

    public void setZhfrom(String zhfrom) {
        this.zhfrom = zhfrom;
    }

    public Boolean getIsts() {
        return ists;
    }

    public void setIsts(Boolean ists) {
        this.ists = ists;
    }

    public Long getDate4() {
        return date4;
    }

    public void setDate4(Long date4) {
        this.date4 = date4;
    }

    public Boolean getIssh() {
        return issh;
    }

    public void setIssh(Boolean issh) {
        this.issh = issh;
    }

    public Boolean getIskp() {
        return iskp;
    }

    public void setIskp(Boolean iskp) {
        this.iskp = iskp;
    }

    public Boolean getIsgcfp() {
        return isgcfp;
    }

    public void setIsgcfp(Boolean isgcfp) {
        this.isgcfp = isgcfp;
    }

    public Integer getMylx() {
        return mylx;
    }

    public void setMylx(Integer mylx) {
        this.mylx = mylx;
    }

    public Boolean getIshx() {
        return ishx;
    }

    public void setIshx(Boolean ishx) {
        this.ishx = ishx;
    }

    public Long getDate5() {
        return date5;
    }

    public void setDate5(Long date5) {
        this.date5 = date5;
    }

    public Boolean getIswcts() {
        return iswcts;
    }

    public void setIswcts(Boolean iswcts) {
        this.iswcts = iswcts;
    }

    public Boolean getIshkqf() {
        return ishkqf;
    }

    public void setIshkqf(Boolean ishkqf) {
        this.ishkqf = ishkqf;
    }

    public String getQgchk() {
        return qgchk;
    }

    public void setQgchk(String qgchk) {
        this.qgchk = qgchk;
    }

    public String getKrqk() {
        return krqk;
    }

    public void setKrqk(String krqk) {
        this.krqk = krqk;
    }

    public Boolean getIsok() {
        return isok;
    }

    public void setIsok(Boolean isok) {
        this.isok = isok;
    }

    public String getKrkpdz() {
        return krkpdz;
    }

    public void setKrkpdz(String krkpdz) {
        this.krkpdz = krkpdz;
    }

    public String getKrfhdz() {
        return krfhdz;
    }

    public void setKrfhdz(String krfhdz) {
        this.krfhdz = krfhdz;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
