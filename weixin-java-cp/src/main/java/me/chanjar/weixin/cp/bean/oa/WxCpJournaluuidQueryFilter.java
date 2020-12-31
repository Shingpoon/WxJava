package me.chanjar.weixin.cp.bean.oa;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import me.chanjar.weixin.common.util.json.WxGsonBuilder;

/**
 * 过滤条件
 * @author panhaocheng@3vjia.com
 * @since 2020-12-30 11:26
 */
@Data
public class WxCpJournaluuidQueryFilter {

  private static final long serialVersionUID = 3318064927980231802L;

  private WxCpApprovalInfoQueryFilter.KEY key;

  private Object value;

  public String toJson() {
    return WxGsonBuilder.create().toJson(this);
  }

  public static enum KEY {

    /**
     * template_id - 模板类型/模板id；
     */
    @SerializedName("template_id")
    TEMPLATE_ID("template_id"),
    /**
     * creator - 申请人；
     */
    @SerializedName("creator")
    CREATOR("creator"),
    /**
     * department - 审批单提单者所在部门；
     */
    @SerializedName("department")
    DEPARTMENT("department"),;

    private String value;

    private KEY(String value) {
      this.value = value;
    }
  }

}
