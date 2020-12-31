package me.chanjar.weixin.cp.bean.oa;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import me.chanjar.weixin.cp.bean.oa.templatedata.TemplateContent;
import me.chanjar.weixin.cp.bean.oa.templatedata.TemplateTitle;

import java.io.Serializable;
import java.util.List;

/**
 * 汇报记录单号
 *
 * @author phc
 */
@Data
public class WxCpJournaluuidListResult implements Serializable {
  private static final long serialVersionUID = 1L;

  @SerializedName("errcode")
  private Integer errCode;

  @SerializedName("errmsg")
  private String errMsg;

  @SerializedName("journaluuid_list")
  private List<String> journaluuidList;

  @SerializedName("next_cursor")
  private Integer nextCursor;

  @SerializedName("endflag")
  private Integer endflag;

}
