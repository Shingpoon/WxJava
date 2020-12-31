package me.chanjar.weixin.cp.bean.oa;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import me.chanjar.weixin.cp.bean.oa.applydata.ApplyDataContent;

import java.io.Serializable;
import java.util.List;

/**
 * 汇报记录详情
 *
 * @author panhaocheng@3vjia.com
 */
@Data
public class WxCpJournalDetail implements Serializable {
  private static final long serialVersionUID = 1L;

  @SerializedName("journal_uuid")
  private String journaluuid;

  @SerializedName("template_name")
  private String templateName;

  @SerializedName("report_time")
  private Long reportTime;

  @SerializedName("submitter")
  private Submitter submitter;

  @SerializedName("receivers")
  private List<Receiver> receivers;

  @SerializedName("readed_receivers")
  private List<Receiver> readedReceivers;

  @SerializedName("apply_data")
  private WxCpJournalDetailApplyData applyData;

  @SerializedName("comments")
  private List<Comment> comments;

  /** “汇报”模板数据，内容为富文本。“汇报”模板是一个特殊模板其表单不在apply_data中返回 */
  @SerializedName("sys_journal_data")
  private String sysJournalData;


  @Data
  public static class Submitter implements Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("userid")
    private String userId;
  }

  @Data
  public static class Receiver implements Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("userid")
    private String userId;
  }

  @Data
  public static class WxCpJournalDetailApplyData implements Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("contents")
    private List<ApplyDataContent> contents;

  }

  @Data
  public static class Comment implements Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("commentid")
    private Long commentid;

    @SerializedName("tocommentid")
    private Long tocommentid;

    @SerializedName("comment_userinfo")
    private CommentUserInfo commentUserinfo;

    @SerializedName("content")
    private String content;

    @SerializedName("comment_time")
    private Long commentTime;

  }

  @Data
  public static class CommentUserInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("userid")
    private String userId;
  }



}
