package me.chanjar.weixin.cp.bean.oa.applydata;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author element
 */
@Data
@Accessors(chain = true)
public class ContentValue implements Serializable {
  private static final long serialVersionUID = -5607678965965065261L;

  private String text;

  @SerializedName("new_number")
  private String newNumber;

  @SerializedName("new_money")
  private String newMoney;

  private ContentValue.Date date;

  private ContentValue.Selector selector;

  private List<ContentValue.Member> members;

  private List<ContentValue.Department> departments;

  private List<ContentValue.File> files;

  private List<ContentValue.Child> children;

  private Attendance attendance;

  @SerializedName("date_range")
  private DateRange dateRange;

  private Location location;

  private Formula formula;

  @Data
  public static class Date implements Serializable {
    private static final long serialVersionUID = -6181554080062231138L;
    private String type;

    @SerializedName("s_timestamp")
    private String timestamp;
  }

  @Data
  public static class Selector implements Serializable {
    private static final long serialVersionUID = 7305458759126951773L;
    private String type;
    private List<Option> options;

    @Data
    public static class Option implements Serializable {
      private static final long serialVersionUID = -3471071106328280252L;
      private String key;

      @SerializedName("value")
      private List<ContentTitle> values;
    }

  }

  @Data
  public static class Member implements Serializable {

    private static final long serialVersionUID = 1316551341955496067L;
    @SerializedName("userid")
    private String userId;
    private String name;
  }

  @Data
  public static class Department implements Serializable {
    private static final long serialVersionUID = -2513762192924826234L;

    @SerializedName("openapi_id")
    private String openApiId;
    private String name;
  }

  @Data
  public static class File implements Serializable {
    private static final long serialVersionUID = 3890971381800855142L;

    @SerializedName("file_id")
    private String fileId;
  }

  @Data
  public static class Child implements Serializable {
    private static final long serialVersionUID = -3500102073821161558L;
    private List<ApplyDataContent> list;
  }


  @Data
  public static class Attendance implements Serializable {
    private static final long serialVersionUID = -6627566040706594166L;
    @SerializedName("date_range")
    private DateRange dateRange;
    private Integer type;

  }

  @Data
  public static class DateRange implements Serializable {
    private static final long serialVersionUID = -3411836592583718255L;
    private String type;
    @SerializedName("new_begin")
    private Long begin;
    @SerializedName("new_end")
    private Long end;
    @SerializedName("new_duration")
    private Long duration;
  }

  @Data
  public static class Location implements Serializable {
    /**	纬度，精确到6位小数*/
    private Double latitude;
    /** 经度，精确到6位小数*/
    private Double longitude;
    /** 地点标题*/
    private String title;
    /** 地点详情地址 */
    private String address;
    /** 选择地点的时间*/
    private Long time;

  }

  @Data
  public static class Formula implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 公式的值*/
    private String value;
  }

}
