package me.chanjar.weixin.cp.api.impl;

import com.google.gson.Gson;
import com.google.inject.Inject;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.cp.api.ApiTestModule;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.bean.oa.*;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 企业微信 OA数据接口 测试用例
 *
 * @author Element
 */

@Guice(modules = ApiTestModule.class)
public class WxCpOaServiceImplTest {

  @Inject
  protected WxCpService wxService;

  @Inject
  protected Gson gson;

  @Test
  public void testGetCheckinData() throws ParseException, WxErrorException {
    Date startTime = DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.parse("2019-04-11");
    Date endTime = DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.parse("2019-05-10");

    List<WxCpCheckinData> results = wxService.getOaService()
      .getCheckinData(1, startTime, endTime, Lists.newArrayList("binary"));

    assertThat(results).isNotNull();

    System.out.println("results ");
    System.out.println(gson.toJson(results));

  }

  @Test
  public void testGetCheckinOption() throws WxErrorException {

    Date now = new Date();
    List<WxCpCheckinOption> results = wxService.getOaService().getCheckinOption(now, Lists.newArrayList("binary"));
    assertThat(results).isNotNull();
    System.out.println("results ");
    System.out.println(gson.toJson(results));
  }

  @Test
  public void testGetApprovalInfo() throws WxErrorException, ParseException {
    Date startTime = DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.parse("2019-12-01");
    Date endTime = DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.parse("2019-12-31");
    WxCpApprovalInfo result = wxService.getOaService().getApprovalInfo(startTime, endTime);

    assertThat(result).isNotNull();

    System.out.println("result ");
    System.out.println(gson.toJson(result));
  }

  @Test
  public void testGetApprovalDetail() throws WxErrorException {
    String spNo = "201912020001";
    WxCpApprovalDetailResult result = wxService.getOaService().getApprovalDetail(spNo);

    assertThat(result).isNotNull();

    System.out.println("result ");
    System.out.println(gson.toJson(result));
  }

  @Test
  public void testGetTemplateDetail() throws WxErrorException {
    String templateId = "3TkZjxugodbqpEMk9j7X6h6zKqYkc7MxQrrFmT7H";
    WxCpTemplateResult result = wxService.getOaService().getTemplateDetail(templateId);
    assertThat(result).isNotNull();
    System.out.println("result ");
    System.out.println(gson.toJson(result));
  }

  @Test
  public void testApply() throws WxErrorException {
    this.wxService.getOaService().apply(new WxCpOaApplyEventRequest().setCreatorUserId("123"));
  }

  @Test
  public void testGetApprovalData() {
  }

  @Test
  public void testGetDialRecord() {
  }

  @Test
  public void testGetJournalUUidList() throws WxErrorException, ParseException {
    Date startTime = DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.parse("2020-12-03");
    Date endTime = DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.parse("2021-01-01");
    WxCpJournaluuidListResult journalUUidList = wxService.getOaService().getJournalUUidList(startTime, endTime, 0, 100, null);

    assertThat(journalUUidList).isNotNull();

    System.out.println("result ");
    System.out.println(gson.toJson(journalUUidList));
  }

  @Test
  public void testGetJournalDetail() throws WxErrorException {
    //5csL48kRfsLRD81vmkEsjXvo9ojSazEHQZrwPdpZxbnzq5Vgt4YmCtSK11gCbn8num
    //5csL48kRfsLRD81vmkEsjXjKT9fEW9rJ6ETym484gVhsijQSbrx5asPc8YACTyKesM
    // 5csL48kRfsLRD81vmkEsjXrrDPTwpz336ibPDMamnksPzP1rzL1d1sRk6767KxrCq9
    WxCpJournalDetail journalDetail = wxService.getOaService().getJournalDetail("5csL48kRfsLRD81vmkEsjXrrDPTwpz336ibPDMamnksPzP1rzL1d1sRk6767KxrCq9");

    assertThat(journalDetail).isNotNull();

    System.out.println("result ");
    System.out.println(gson.toJson(journalDetail));
  }
}
