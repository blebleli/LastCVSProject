package kr.or.ddit.commons.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import kr.or.ddit.model.BarcodeVo;
import kr.or.ddit.model.BookmarkVo;
import kr.or.ddit.model.ProdVo;
import kr.or.ddit.model.StockListVo;
import kr.or.ddit.model.StockVo;
import kr.or.ddit.model.SupplyListVo;
import kr.or.ddit.model.SupplyVo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/config/spring/root-context.xml",
								 "classpath:kr/or/ddit/config/spring/transaction.xml",
								 "classpath:kr/or/ddit/config/spring/datasource_dev.xml"})
public class dbTests {
	
	@Resource(name="autoCodeCreate")
	private AutoCodeCreate code;
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	private Date today = new Date();
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());	
	
	@Test
	public void formoon() throws ParseException{
		
		List<ProdVo> prodList = template.selectList("test.prodTest");
		logger.debug("prodList {} ========================>>>> ",prodList);
		
		BarcodeVo barcodeVo = null;
		SupplyVo supplyVo = null;
		SupplyListVo supplyListVo = null;
		
			// 편의점         
			String[] mem_id = {	            
	            // 대전 65건
	             "3650000-104-2017-00068"
	            ,"3660000-104-2017-00128"
	            ,"3670000-104-2011-00081"
	            ,"3660000-104-2015-00114"
	            ,"3640000-104-2016-00064"
	            ,"3650000-104-2017-00009"
	            ,"3660000-104-2017-00041"
	            ,"3650000-104-2017-00034"
	            ,"3680000-104-2010-00018"
	            ,"3660000-104-2018-00152"
	            ,"3680000-104-2014-00012"
	            ,"3680000-104-2014-00013"
	            ,"3680000-104-2014-00016"
	            ,"3680000-104-2018-00042"
	            ,"3660000-104-2018-00197"
	            ,"3680000-104-2016-00049"
	            ,"3640000-104-2018-00024"
	            ,"3650000-104-2016-00005"
	            ,"3640000-104-2016-00033"
	            ,"3640000-104-2016-00074"
	            ,"3640000-104-2018-00034"
	            ,"3640000-104-2017-00018"
	            ,"3650000-104-2014-00001"
	            ,"3650000-104-2015-00043"
	            ,"3660000-104-2017-00055"
	            ,"3660000-104-2015-00189"
	            ,"3660000-104-2010-00023"
	            ,"3660000-104-2011-00085"
	            ,"3660000-104-2012-00022"
	            ,"3660000-104-2012-00024"
	            ,"3660000-104-2012-00040"
	            ,"3660000-104-2011-00171"
	            ,"3660000-104-2011-00146"
	            ,"3660000-104-2013-00016"
	            ,"3660000-104-2018-00100"
	            ,"3660000-104-2018-00090"
	            ,"3660000-104-2018-00055"
	            ,"3660000-104-2018-00076"
	            ,"3660000-104-2015-00131"
	            ,"3640000-104-2018-00010"
	            ,"3650000-104-2017-00132"
	            ,"3660000-104-2018-00031"
	            ,"3660000-104-2017-00224"
	            ,"3660000-104-2017-00159"
	            ,"3650000-104-2015-00091"
	            ,"3640000-104-2017-00120"
	            ,"3660000-104-2017-00094"
	            ,"3640000-104-2010-00003"
	            ,"3640000-104-2012-00030"
	            ,"3640000-104-2014-00004"
	            ,"3640000-104-2014-00044"
	            ,"3640000-104-2017-00117"
	            ,"3650000-104-2010-00055"
	            ,"3650000-104-2014-00080"
	            ,"3650000-104-2014-00020"
	            ,"3660000-104-2018-00043"
	            ,"3650000-104-2015-00093"
	            ,"3650000-104-2017-00076"
	            ,"3680000-104-2017-00035"
	            ,"3660000-104-2017-00153"
	            ,"3650000-104-2017-00095"
	            ,"3660000-104-2017-00110"
	            ,"3660000-104-2017-00190"
	            
	            // 세종 16
	            ,"5690000-104-2016-00146"
	            ,"5690000-104-2017-00111"
	            ,"5690000-104-2015-00047"
	            ,"5690000-104-2010-00007"
	            ,"5690000-104-2011-00003"
	            ,"5690000-104-2011-00006"
	            ,"5690000-104-2014-00049"
	            ,"5690000-104-2018-00057"
	            ,"3760000-104-2018-00079"
	            ,"5690000-104-2018-00090"
	            ,"5690000-104-2017-00013"
	            ,"5690000-104-2018-00064"
	            ,"5690000-104-2017-00140"
	            ,"5690000-104-2017-00201"
	            ,"5690000-104-2018-00034"
	            ,"5690000-104-2017-00064"
	            
//	            // 충청 374
//	            ,"4390000-104-2016-00060"
//	            ,"4520000-104-2016-00071"
//	            ,"4550000-104-2016-00008"
//	            ,"4610000-104-2017-00017"
//	            ,"4600000-104-2017-00026"
//	            ,"4610000-104-2017-00020"
//	            ,"5730000-104-2016-00002"
//	            ,"5680000-104-2017-00050"
//	            ,"4390000-104-2009-00030"
//	            ,"4390000-104-2009-00031"
//	            ,"4390000-104-2012-00054"
//	            ,"4390000-104-2011-00055"
//	            ,"4390000-104-2013-00003"
//	            ,"4390000-104-2012-00035"
//	            ,"4390000-104-2012-00037"
//	            ,"4390000-104-2012-00006"
//	            ,"4390000-104-2012-00007"
//	            ,"4390000-104-2012-00041"
//	            ,"4390000-104-2012-00042"
//	            ,"4390000-104-2012-00045"
//	            ,"4390000-104-2012-00018"
//	            ,"4390000-104-2012-00048"
//	            ,"4390000-104-2012-00019"
//	            ,"4390000-104-2011-00043"
//	            ,"4390000-104-2011-00044"
//	            ,"4390000-104-2011-00045"
//	            ,"4390000-104-2011-00013"
//	            ,"4390000-104-2012-00001"
//	            ,"4390000-104-2012-00002"
//	            ,"4390000-104-2011-00030"
//	            ,"4390000-104-2011-00037"
//	            ,"4390000-104-2011-00006"
//	            ,"4390000-104-2011-00007"
//	            ,"4390000-104-2010-00016"
//	            ,"4390000-104-2010-00017"
//	            ,"4390000-104-2011-00024"
//	            ,"4390000-104-2014-00006"
//	            ,"4390000-104-2013-00034"
//	            ,"4390000-104-2014-00017"
//	            ,"4390000-104-2014-00019"
//	            ,"4390000-104-2013-00044"
//	            ,"4390000-104-2013-00022"
//	            ,"4390000-104-2013-00050"
//	            ,"4520000-104-2012-00075"
//	            ,"4520000-104-2011-00045"
//	            ,"4520000-104-2011-00092"
//	            ,"4520000-104-2011-00093"
//	            ,"4520000-104-2012-00002"
//	            ,"4520000-104-2011-00009"
//	            ,"4520000-104-2011-00011"
//	            ,"4520000-104-2011-00013"
//	            ,"4520000-104-2011-00014"
//	            ,"4520000-104-2011-00016"
//	            ,"4520000-104-2011-00019"
//	            ,"4520000-104-2011-00020"
//	            ,"4520000-104-2011-00021"
//	            ,"4520000-104-2011-00025"
//	            ,"4520000-104-2011-00028"
//	            ,"4520000-104-2011-00042"
//	            ,"4520000-104-2011-00043"
//	            ,"4520000-104-2012-00043"
//	            ,"4520000-104-2015-00001"
//	            ,"4520000-104-2014-00080"
//	            ,"4520000-104-2014-00041"
//	            ,"4520000-104-2014-00050"
//	            ,"4520000-104-2013-00015"
//	            ,"4520000-104-2013-00055"
//	            ,"4520000-104-2013-00017"
//	            ,"4600000-104-2015-00023"
//	            ,"4520000-104-2016-00002"
//	            ,"4390000-104-2015-00067"
//	            ,"5730000-104-2015-00081"
//	            ,"5730000-104-2016-00043"
//	            ,"5730000-104-2016-00044"
//	            ,"5725000-104-2016-00025"
//	            ,"4440000-104-2017-00003"
//	            ,"4530000-104-2017-00029"
//	            ,"5660000-104-2017-00034"
//	            ,"4470000-104-2017-00031"
//	            ,"4590000-104-2017-00001"
//	            ,"4530000-104-2017-00012"
//	            ,"4530000-104-2017-00032"
//	            ,"4400000-104-2017-00013"
//	            ,"4450000-104-2015-00024"
//	            ,"4530000-104-2015-00042"
//	            ,"4450000-104-2015-00010"
//	            ,"4520000-104-2015-00059"
//	            ,"4600000-104-2015-00022"
//	            ,"4520000-104-2018-00069"
//	            ,"4520000-104-2016-00096"
//	            ,"4570000-104-2013-00003"
//	            ,"5680000-104-2018-00054"
//	            ,"5660000-104-2018-00162"
//	            ,"4580000-104-2018-00012"
//	            ,"4390000-104-2016-00061"
//	            ,"4620000-104-2018-00018"
//	            ,"4570000-104-2014-00014"
//	            ,"4570000-104-2014-00023"
//	            ,"4470000-104-2013-00002"
//	            ,"4600000-104-2011-00006"
//	            ,"4600000-104-2011-00013"
//	            ,"4600000-104-2011-00018"
//	            ,"4600000-104-2011-00019"
//	            ,"4600000-104-2011-00024"
//	            ,"4600000-104-2011-00025"
//	            ,"4600000-104-2011-00028"
//	            ,"4600000-104-2014-00018"
//	            ,"4600000-104-2013-00018"
//	            ,"4600000-104-2015-00001"
//	            ,"4600000-104-2012-00004"
//	            ,"4600000-104-2013-00009"
//	            ,"4600000-104-2012-00005"
//	            ,"4600000-104-2016-00069"
//	            ,"4470000-104-2011-00024"
//	            ,"4470000-104-2011-00025"
//	            ,"4470000-104-2012-00002"
//	            ,"4450000-104-2015-00032"
//	            ,"5650000-104-2016-00037"
//	            ,"4400000-104-2016-00016"
//	            ,"4460000-104-2011-00005"
//	            ,"4460000-104-2013-00007"
//	            ,"4480000-104-2009-00001"
//	            ,"4480000-104-2012-00001"
//	            ,"4480000-104-2015-00002"
//	            ,"4510000-104-2013-00001"
//	            ,"4550000-104-2017-00002"
//	            ,"5660000-104-2018-00151"
//	            ,"5660000-104-2018-00152"
//	            ,"4580000-104-2013-00004"
//	            ,"4520000-104-2016-00072"
//	            ,"4400000-104-2018-00039"
//	            ,"4550000-104-2012-00008"
//	            ,"4550000-104-2013-00001"
//	            ,"4550000-104-2013-00002"
//	            ,"4620000-104-2013-00005"
//	            ,"4620000-104-2014-00019"
//	            ,"5660000-104-2016-00106"
//	            ,"5570000-104-2012-00008"
//	            ,"5570000-104-2014-00004"
//	            ,"5570000-104-2012-00010"
//	            ,"5570000-104-2015-00002"
//	            ,"5650000-104-2016-00044"
//	            ,"4500000-104-2011-00044"
//	            ,"4500000-104-2015-00013"
//	            ,"4500000-104-2015-00017"
//	            ,"4440000-104-2016-00014"
//	            ,"5660000-104-2015-00031"
//	            ,"5660000-104-2015-00037"
//	            ,"5650000-104-2015-00051"
//	            ,"5660000-104-2015-00059"
//	            ,"4500000-104-2017-00012"
//	            ,"5660000-104-2018-00160"
//	            ,"5650000-104-2017-00018"
//	            ,"5660000-104-2018-00146"
//	            ,"4470000-104-2018-00038"
//	            ,"4610000-104-2015-00018"
//	            ,"4540000-104-2015-00022"
//	            ,"4470000-104-2017-00010"
//	            ,"4570000-104-2015-00028"
//	            ,"4600000-104-2016-00075"
//	            ,"4600000-104-2017-00005"
//	            ,"4530000-104-2018-00052"
//	            ,"4400000-104-2017-00011"
//	            ,"4620000-104-2018-00020"
//	            ,"4530000-104-2016-00016"
//	            ,"5660000-104-2016-00053"
//	            ,"5650000-104-2018-00094"
//	            ,"5660000-104-2016-00011"
//	            ,"4530000-104-2016-00091"
//	            ,"5680000-104-2017-00032"
//	            ,"4610000-104-2013-00003"
//	            ,"4610000-104-2016-00025"
//	            ,"4470000-104-2012-00004"
//	            ,"4470000-104-2015-00015"
//	            ,"4530000-104-2017-00028"
//	            ,"4520000-104-2018-00015"
//	            ,"4620000-104-2018-00002"
//	            ,"4620000-104-2017-00042"
//	            ,"5720000-104-2018-00032"
//	            ,"4600000-104-2017-00031"
//	            ,"4580000-104-2015-00015"
//	            ,"5650000-104-2016-00159"
//	            ,"4600000-104-2016-00073"
//	            ,"5650000-104-2018-00002"
//	            ,"4540000-104-2015-00034"
//	            ,"4610000-104-2011-00005"
//	            ,"4610000-104-2014-00022"
//	            ,"5735000-104-2015-00080"
//	            ,"5660000-104-2017-00229"
//	            ,"5680000-104-2018-00010"
//	            ,"5725000-104-2018-00005"
//	            ,"5660000-104-2015-00071"
//	            ,"5730000-104-2016-00040"
//	            ,"5660000-104-2018-00056"
//	            ,"4470000-104-2016-00024"
//	            ,"4600000-104-2018-00020"
//	            ,"5730000-104-2016-00055"
//	            ,"4580000-104-2016-00007"
//	            ,"4580000-104-2016-00008"
//	            ,"4390000-104-2017-00135"
//	            ,"4620000-104-2017-00045"
//	            ,"5650000-104-2010-00042"
//	            ,"5660000-104-2011-00082"
//	            ,"5660000-104-2011-00073"
//	            ,"5660000-104-2011-00020"
//	            ,"4530000-104-2018-00011"
//	            ,"5650000-104-2011-00017"
//	            ,"5660000-104-2011-00063"
//	            ,"5660000-104-2011-00041"
//	            ,"5660000-104-2011-00043"
//	            ,"5660000-104-2012-00038"
//	            ,"5650000-104-2012-00051"
//	            ,"5650000-104-2014-00027"
//	            ,"5660000-104-2014-00035"
//	            ,"5660000-104-2013-00034"
//	            ,"5650000-104-2014-00060"
//	            ,"5660000-104-2015-00018"
//	            ,"5650000-104-2015-00002"
//	            ,"5720000-104-2016-00076"
//	            ,"5735000-104-2018-00032"
//	            ,"4520000-104-2016-00144"
//	            ,"4530000-104-2018-00033"
//	            ,"5730000-104-2018-00063"
//	            ,"5680000-104-2017-00006"
//	            ,"5680000-104-2017-00005"
//	            ,"4450000-104-2018-00010"
//	            ,"4440000-104-2018-00007"
//	            ,"4470000-104-2018-00027"
//	            ,"5730000-104-2016-00009"
//	            ,"4450000-104-2015-00030"
//	            ,"5680000-104-2010-00006"
//	            ,"5680000-104-2011-00008"
//	            ,"5680000-104-2011-00035"
//	            ,"5680000-104-2012-00004"
//	            ,"5680000-104-2012-00011"
//	            ,"5680000-104-2012-00034"
//	            ,"5680000-104-2012-00035"
//	            ,"5680000-104-2012-00046"
//	            ,"5680000-104-2012-00048"
//	            ,"5680000-104-2013-00006"
//	            ,"5680000-104-2013-00013"
//	            ,"5680000-104-2013-00018"
//	            ,"5680000-104-2013-00021"
//	            ,"5680000-104-2013-00042"
//	            ,"5650000-104-2018-00055"
//	            ,"4470000-104-2018-00021"
//	            ,"5660000-104-2018-00004"
//	            ,"5725000-104-2017-00102"
//	            ,"5680000-104-2016-00085"
//	            ,"4520000-104-2016-00130"
//	            ,"5680000-104-2017-00058"
//	            ,"4600000-104-2017-00050"
//	            ,"4450000-104-2017-00054"
//	            ,"5680000-104-2017-00098"
//	            ,"4400000-104-2014-00002"
//	            ,"4400000-104-2014-00011"
//	            ,"4400000-104-2012-00044"
//	            ,"4400000-104-2012-00045"
//	            ,"4400000-104-2012-00012"
//	            ,"4400000-104-2013-00025"
//	            ,"4400000-104-2013-00026"
//	            ,"4530000-104-2015-00030"
//	            ,"4400000-104-2016-00052"
//	            ,"4390000-104-2017-00120"
//	            ,"4600000-104-2015-00015"
//	            ,"4600000-104-2017-00024"
//	            ,"5660000-104-2015-00088"
//	            ,"5650000-104-2011-00048"
//	            ,"5680000-104-2017-00090"
//	            ,"5660000-104-2017-00076"
//	            ,"4510000-104-2017-00030"
//	            ,"5660000-104-2017-00142"
//	            ,"5680000-104-2017-00083"
//	            ,"5680000-104-2017-00084"
//	            ,"4470000-104-2016-00004"
//	            ,"5660000-104-2016-00091"
//	            ,"4520000-104-2017-00050"
//	            ,"4620000-104-2017-00018"
//	            ,"4390000-104-2017-00132"
//	            ,"4620000-104-2017-00010"
//	            ,"5660000-104-2017-00157"
//	            ,"4610000-104-2016-00023"
//	            ,"4620000-104-2017-00031"
//	            ,"4390000-104-2018-00006"
//	            ,"4520000-104-2017-00113"
//	            ,"4470000-104-2017-00068"
//	            ,"5660000-104-2017-00237"
//	            ,"5650000-104-2017-00234"
//	            ,"4540000-104-2016-00016"
//	            ,"5580000-104-2013-00007"
//	            ,"5680000-104-2016-00011"
//	            ,"4470000-104-2016-00006"
//	            ,"4390000-104-2018-00013"
//	            ,"4570000-104-2013-00004"
//	            ,"4390000-104-2017-00093"
//	            ,"5660000-104-2017-00092"
//	            ,"4400000-104-2018-00010"
//	            ,"4440000-104-2013-00004"
//	            ,"4530000-104-2014-00008"
//	            ,"4530000-104-2013-00027"
//	            ,"4530000-104-2013-00015"
//	            ,"4530000-104-2011-00029"
//	            ,"4530000-104-2011-00030"
//	            ,"4530000-104-2011-00036"
//	            ,"4530000-104-2011-00043"
//	            ,"4530000-104-2011-00044"
//	            ,"4540000-104-2017-00064"
//	            ,"4530000-104-2012-00017"
//	            ,"4530000-104-2013-00003"
//	            ,"4520000-104-2017-00112"
//	            ,"4470000-104-2016-00074"
//	            ,"4600000-104-2018-00006"
//	            ,"4600000-104-2017-00043"
//	            ,"4610000-104-2017-00033"
//	            ,"5660000-104-2017-00211"
//	            ,"5650000-104-2017-00213"
//	            ,"4530000-104-2015-00019"
//	            ,"4400000-104-2015-00011"
//	            ,"4400000-104-2015-00017"
//	            ,"5725000-104-2017-00123"
//	            ,"5735000-104-2017-00135"
//	            ,"5680000-104-2015-00041"
//	            ,"4390000-104-2015-00037"
//	            ,"4500000-104-2018-00006"
//	            ,"4610000-104-2017-00005"
//	            ,"5650000-104-2017-00060"
//	            ,"5735000-104-2010-04019"
//	            ,"4600000-104-2017-00018"
//	            ,"4570000-104-2016-00005"
//	            ,"4600000-104-2017-00027"
//	            ,"4600000-104-2017-00032"
//	            ,"4600000-104-2017-00033"
//	            ,"5650000-104-2016-00061"
//	            ,"4600000-104-2017-00017"
//	            ,"4390000-104-2017-00091"
//	            ,"4600000-104-2018-00033"
//	            ,"4510000-104-2018-00022"
//	            ,"4530000-104-2017-00064"
//	            ,"4390000-104-2017-00072"
//	            ,"4540000-104-2016-00046"
//	            ,"4530000-104-2016-00078"
//	            ,"4470000-104-2017-00053"
//	            ,"4550000-104-2014-00011"
//	            ,"4590000-104-2012-00002"
//	            ,"4590000-104-2013-00001"
//	            ,"4590000-104-2014-00008"
//	            ,"4530000-104-2017-00051"
//	            ,"4540000-104-2017-00046"
//	            ,"4470000-104-2017-00060"
//	            ,"5720000-104-2011-01058"
//	            ,"5730000-104-2013-02024"
//	            ,"5730000-104-2013-02030"
//	            ,"5730000-104-2013-02035"
//	            ,"5730000-104-2013-04012"
//	            ,"5735000-104-2010-01017"
//	            ,"5735000-104-2010-04009"
//	            ,"5735000-104-2010-04027"
//	            ,"5735000-104-2013-04009"
//	            ,"5735000-104-2013-04011"
//	            ,"5735000-104-2013-04024"
//	            ,"4450000-104-2011-00009"
//	            ,"4450000-104-2014-00010"
//	            ,"4450000-104-2014-00014"
//	            ,"4450000-104-2013-00011"
//	            ,"4450000-104-2011-00001"
//	            ,"4540000-104-2014-00050"
//	            ,"4540000-104-2015-00001"
//	            ,"4540000-104-2015-00002"
//	            ,"4540000-104-2013-00031"
//	            ,"5735000-104-2017-00114"
//	            ,"4540000-104-2014-00017"
//	            ,"4540000-104-2013-00010"
//	            ,"4540000-104-2011-00024"
//	            ,"5680000-104-2017-00068"
	      };
	      
//		SupplyListVo supplyListVo = null;
		Random random = new Random();
//		int sum = 30;
//		int ran = random.nextInt((10)+1);
		String[] date = {"2018-10-15 12:22","2018-10-16 15:12","2018-10-17 12:22"}; // 날짜
		String[] e_date = {"2018-11-15 12:22","2018-11-16 15:12","2018-11-17 12:22"}; // 날짜
		String[] state = {"10","11","12"};
		String bcd_path = "/barcode/supply";
		String[] prod_ids = { "meal-00351",
							   "meal-00136",
							   "meal-00182",
							   "meal-00516",
							   "meal-00017",				   
							   "biscuit-01026",
							   "biscuit-00368",
							   "biscuit-00405",
							   "biscuit-00187",
							   "biscuit-00238",				   
							   "ice-00003",
							   "ice-00126",
							   "ice-00175",
							   "ice-00183",
							   "ice-00066",				   
							   "food-01065",
							   "food-00591",
							   "food-00489",
							   "food-00577",
							   "food-00494",				   
							   "drink-00866",
							   "drink-00558",
							   "drink-01076",
							   "drink-00557",
							   "drink-00002",				   
							   "necessities-01022",
							   "necessities-00442",
							   "necessities-01026",
							   "necessities-00835",
							   "necessities-00704"};		
		
		for ( int x = 0; x < date.length; x++) { // 날짜 11 ~ 17 date.length
				supplyVo = new SupplyVo();
				supplyListVo = new SupplyListVo();
				Date supply_date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(date[x]); // String을 Date로 변환
				Date ex_date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(e_date[x]); // String을 Date로 변환
				supplyVo.setSupply_date(supply_date); // 날짜 저장
				supplyListVo.setSplylist_exdate(ex_date);
				
			for ( int a = 0; a < state.length; a++) { // 발주, 승인, 입고 state.length					
					supplyVo.setSupply_state(state[a]); // 진행상태 저장
					
				for ( int i = 0; i < mem_id.length; i++){ // 편의점 400곳 mem_id.length					
					String supply = code.barcode("SUPPLY"); // 바코드 400, 수불신청 400 // 발주 : 400, 승인 400, 입고  400, (마감 400, 재고 400)
					barcodeVo = new BarcodeVo();
					barcodeVo.setBcd_id(supply);
					barcodeVo.setBcd_content("발주 바코드 생성..");
					barcodeVo.setBcd_path(bcd_path);
					barcodeVo.setBcd_kind("102");
					
					supplyVo.setSupply_bcd(supply); // supply 수불바코드 저장
					
					if(supplyVo.getSupply_state().equals("10")){ // 진행상태가 발주
						supplyVo.setSupply_info("success"); // 비고에 "발주신청"으로 저장
					}else if(supplyVo.getSupply_state().equals("11")){ // 결제면
						supplyVo.setSupply_info("발주승인."); // "발주승인"으로
					}else if(supplyVo.getSupply_state().equals("12")){ // 입고면
						supplyVo.setSupply_info("입고완료."); // "입고완료"로 저장
					}
					
					supplyVo.setPlace_id(mem_id[i]); // 수불신청 편의점 이름 저장
					
					template.insert("barcode.insertBarcode", barcodeVo);
					template.insert("supply.insertSupply", supplyVo);
					// 바코드 insert 코딩하기
					// 수불신청 insert 코딩하기
					
//					for (int j = 0; j < 10; j++){ // 수불리스트 10개씩(제품 10개)
//						supplyListVo = new SupplyListVo();						
//						int ran = random.nextInt(prodList.size()-1);	
//						supplyListVo.setProd_id(prodList.get(ran).getProd_id());
//						System.out.println(barcodeVo.getBcd_id());
//						System.out.println(j+"번째"+supply);						
//						// 수불리스트 insert
//					}
					
					for (int z = 0; z < prod_ids.length; z++){ // 수불리스트 고정 30개 prod_ids.length
						int[] sum = {3,5,4,7,6,9,3,2,1,4,2,4,4,6,3,2,1,6,4,2,3,5,3,1,6,3,6,4,1,2};
						String Splylist_id10 = code.autoCode("SUP10",supplyVo.getPlace_id()); // 제품리스트 코드 10 ~ 12(발주, 결제, 입고)
						String Splylist_id11 = code.autoCode("SUP11",supplyVo.getPlace_id());
						String Splylist_id12 = code.autoCode("SUP12",supplyVo.getPlace_id());
						
						if(supplyVo.getSupply_state().equals("10")){ // SUPPY 상태가 발주 중이면
							supplyListVo.setSplylist_id(Splylist_id10); // SupplyList 제품리스트코드를 발주10
							supplyListVo.setSplylist_info("발주신청."); // 비고에는 발주신청
							supplyListVo.setSplylist_sum(sum[z]);
//							int ran = random.nextInt(10)+1;
//							supplyListVo.setSplylist_sum(ran); // 수량 1~10개 랜덤값 저장
						}else if(supplyVo.getSupply_state().equals("11")){ // 결제 중이면
							supplyListVo.setSplylist_id(Splylist_id11); // 결제11
							supplyListVo.setSplylist_info("발주승인."); // 발주승인
							supplyListVo.setSplylist_sum(sum[z]);
						}else if(supplyVo.getSupply_state().equals("12")){ // 입고면
							supplyListVo.setSplylist_id(Splylist_id12); // 입고12로 저장
							supplyListVo.setSplylist_info("입고완료."); // 입고완료로 저장
							supplyListVo.setSplylist_sum(sum[z]);
						}
						
						supplyListVo.setSupply_bcd(supplyVo.getSupply_bcd()); // 수불바코드 저장
						supplyListVo.setProd_id(prod_ids[z]);
						template.insert("supply.insertSupplyList", supplyListVo); // supply_list insert		
					}					
				
				}
			}			
		}
	}
	
	@Test
	public void Event(){ // 행사제품 입력
		ProdVo prodVo = null;
		String[] ganpeon = { "meal-00351", "meal-00136", "meal-00182",
							 "meal-00516", "meal-00017", "meal-00552", "meal-00078",
							 "meal-00049", "meal-00077", "meal-00094", "meal-00033" };
		String[] iceCream = { "ice-00009", "ice-00026", "ice-00003",
							  "ice-00126", "ice-00175", "ice-00043", "ice-00040",
							  "ice-00030", "ice-00031", "ice-00020" };
		String[] cookie = { "biscuit-01051", "biscuit-00161", "biscuit-00230",
							"biscuit-00260", "biscuit-00545", "biscuit-00039",
							"biscuit-00032", "biscuit-00028", "biscuit-00025",
							"biscuit-00022" };
		String[] sicpoom = { "food-01059", "food-01065", "food-00591",
							 "food-00489", "food-00577", "food-00494", "food-00197",
							 "food-00037", "food-00086", "food-00184" };
		String[] drink = { "drink-00866", "drink-00558", "drink-01076",
					       "drink-00557", "drink-00002", "drink-00018", "drink-00004",
					       "drink-00012", "drink-00020", "drink-01111" };
		String[] saenghwal = { "necessities-01022", "necessities-00442",
							   "necessities-01026", "necessities-00835", "necessities-00704",
							   "necessities-00260", "necessities-00014", "necessities-00257",
							   "necessities-00056", "necessities-00070" };
		String[] event_id = { "EVENT1", "EVENT2", "DIS1", "DIS2" };
		
//		for (int j = 3; j <= 3; j++){
			for (int i = 0; i < iceCream.length; i++){
				prodVo = new ProdVo();
				prodVo.setEvent_id("EVENT2");
				prodVo.setProd_id(saenghwal[i]);
				template.update("test.prodEventUpdate", prodVo);
//				prodVo.setProd_id(iceCream[i]);
//				template.update("test.prodEventUpdate", prodVo);
//				prodVo.setProd_id(cookie[i]);
//				template.update("test.prodEventUpdate", prodVo);
//				prodVo.setProd_id(sicpoom[i]);
//				template.update("test.prodEventUpdate", prodVo);
//				prodVo.setProd_id(drink[i]);
//				template.update("test.prodEventUpdate", prodVo);
//				prodVo.setProd_id(saenghwal[i]);
//				template.update("test.prodEventUpdate", prodVo);
			}
//		}
	}
	
	
	@Test // 팀원 6명 발주,승인,입고
	public void formoonTest() throws ParseException{				
		BarcodeVo barcodeVo = null;
		SupplyVo supplyVo = null;
		SupplyListVo supplyListVo = null;
		
		// 편의점         
		String[] mem_id = { "4930000-104-2015-00011", "3380000-104-2014-00017",
							"3670000-104-2012-00104", "3150000-104-2015-00104",
							"3680000-104-2016-00025", "4180000-104-2016-00010" };
		String[] date = {"2018-10-16 13:10","2018-10-17 09:32"}; // 날짜
		String[] e_date = {"2018-11-16 13:10","2018-11-17 09:32"}; // 날짜
		String[] state = {"10","11","12"};
		String bcd_path = "/barcode/supply";
		String[] prod_ids = { "meal-00351",
							   "meal-00136",
							   "meal-00182",
							   "meal-00516",
							   "meal-00017",				   
							   "biscuit-01026",
							   "biscuit-00368",
							   "biscuit-00405",
							   "biscuit-00187",
							   "biscuit-00238",				   
							   "ice-00003",
							   "ice-00126",
							   "ice-00175",
							   "ice-00183",
							   "ice-00066",				   
							   "food-01065",
							   "food-00591",
							   "food-00489",
							   "food-00577",
							   "food-00494",				   
							   "drink-00866",
							   "drink-00558",
							   "drink-01076",
							   "drink-00557",
							   "drink-00002",				   
							   "necessities-01022",
							   "necessities-00442",
							   "necessities-01026",
							   "necessities-00835",
							   "necessities-00704"};		
		
		for ( int x = 0; x < date.length; x++) { // 날짜 11 ~ 17 date.length
				supplyVo = new SupplyVo();
				supplyListVo = new SupplyListVo();
				Date supply_date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(date[x]); // String을 Date로 변환
				Date ex_date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(e_date[x]); // String을 Date로 변환
				supplyVo.setSupply_date(supply_date); // 날짜 저장
				supplyListVo.setSplylist_exdate(ex_date);
				
			for ( int a = 0; a < state.length; a++) { // 발주, 승인, 입고 state.length					
					supplyVo.setSupply_state(state[a]); // 진행상태 저장
					
				for ( int i = 0; i < mem_id.length; i++){ // 편의점 400곳 mem_id.length					
					String supply = code.barcode("SUPPLY"); // 바코드 400, 수불신청 400 // 발주 : 400, 승인 400, 입고  400, (마감 400, 재고 400)
					barcodeVo = new BarcodeVo();
					barcodeVo.setBcd_id(supply);
					barcodeVo.setBcd_content("발주 바코드 생성..");
					barcodeVo.setBcd_path(bcd_path);
					barcodeVo.setBcd_kind("102");
					
					supplyVo.setSupply_bcd(supply); // supply 수불바코드 저장
					
					if(supplyVo.getSupply_state().equals("10")){ // 진행상태가 발주
						supplyVo.setSupply_info("success"); // 비고에 "발주신청"으로 저장
					}else if(supplyVo.getSupply_state().equals("11")){ // 결제면
						supplyVo.setSupply_info("발주승인."); // "발주승인"으로
					}else if(supplyVo.getSupply_state().equals("12")){ // 입고면
						supplyVo.setSupply_info("입고완료."); // "입고완료"로 저장
					}
					
					supplyVo.setPlace_id(mem_id[i]); // 수불신청 편의점 이름 저장
					
					template.insert("barcode.insertBarcode", barcodeVo); // 바코드 insert 코딩하기
					template.insert("supply.insertSupply", supplyVo); // 수불신청 insert 코딩하기
					
					for (int z = 0; z < prod_ids.length; z++){ // 수불리스트 고정 30개 prod_ids.length
						int[] sum = {3,5,4,7,6,9,3,2,1,4,2,4,4,6,3,2,1,6,4,2,3,5,3,1,6,3,6,4,1,2};
						String Splylist_id10 = code.autoCode("SUP10",supplyVo.getPlace_id()); // 제품리스트 코드 10 ~ 12(발주, 결제, 입고)
						String Splylist_id11 = code.autoCode("SUP11",supplyVo.getPlace_id());
						String Splylist_id12 = code.autoCode("SUP12",supplyVo.getPlace_id());
						
						if(supplyVo.getSupply_state().equals("10")){ // SUPPY 상태가 발주 중이면
							supplyListVo.setSplylist_id(Splylist_id10); // SupplyList 제품리스트코드를 발주10
							supplyListVo.setSplylist_info("발주신청."); // 비고에는 발주신청
							supplyListVo.setSplylist_sum(sum[z]);
						}else if(supplyVo.getSupply_state().equals("11")){ // 결제 중이면
							supplyListVo.setSplylist_id(Splylist_id11); // 결제11
							supplyListVo.setSplylist_info("발주승인."); // 발주승인
							supplyListVo.setSplylist_sum(sum[z]);
						}else if(supplyVo.getSupply_state().equals("12")){ // 입고면
							supplyListVo.setSplylist_id(Splylist_id12); // 입고12로 저장
							supplyListVo.setSplylist_info("입고완료."); // 입고완료로 저장
							supplyListVo.setSplylist_sum(sum[z]);
						}						
						supplyListVo.setSupply_bcd(supplyVo.getSupply_bcd()); // 수불바코드 저장
						supplyListVo.setProd_id(prod_ids[z]);
						template.insert("supply.insertSupplyList", supplyListVo); // supply_list insert		
					}				
				}
			}			
		}
	}
			
	@Test
	public void supplyTest() {
		
		BarcodeVo supBarcode = null;
		SupplyVo supply = null;
		SupplyListVo sup = null;
		
		// 편의점 6개(4930000-104-2015-00011는 이미 했음. 16일자 할때 추가해야함)
		String[] mem_id = { "3380000-104-2014-00017", "3670000-104-2012-00104",
							"3150000-104-2015-00104", "3680000-104-2016-00025",
							"4180000-104-2016-00010" };
		// 상품아이디
		String[] prod_id = { "meal-00351","meal-00136", "meal-00182", "meal-00516",
							 "meal-00017", "biscuit-01026", "biscuit-00368",
							 "biscuit-00405", "biscuit-00187", "biscuit-00238", "ice-00003",
							 "ice-00126", "ice-00175", "ice-00183", "ice-00066",
							 "food-01065", "food-00591", "food-00489", "food-00577",
							 "food-00494", "drink-00866", "drink-00558", "drink-01076",
							 "drink-00557", "drink-00002", "necessities-01022",
							 "necessities-00442", "necessities-01026", "necessities-00835",
							 "necessities-00704" };
		// 수량
		int[] sum = {3,5,4,7,6,9,3,2,1,4,2,4,4,6,3,2,1,6,4,2,3,5,3,1,6,3,6,4,1,2};
		
		for(int i = 0; i <= 1; i++){ // mem_id.length
			
			String bcd_id = code.barcode("SUPPLY");
			supBarcode = new BarcodeVo();
			supBarcode.setBcd_id(bcd_id); // 바코드 코드
			supBarcode.setBcd_content("발주 신청"); // 바코드 신청 내용
			supBarcode.setBcd_kind("102"); // 바코드 구분
			supBarcode.setBcd_path("/barcode/supply"); // 바코드 경로
			
			template.insert("barcode.insertBarcode", supBarcode);
//			int barResult = barcodeService.setInsertBarcode(supBarcode); // 바코드 생성
			
			supply = new SupplyVo();
			supply.setPlace_id(mem_id[i]); // 편의점 이름				
			supply.setSupply_bcd(supBarcode.getBcd_id()); // 수불바코드(=바코드 코드)
//			supply.setSupply_date(today); // 일시
			supply.setSupply_state("10"); // 진행상태 : 10은 발주신청
//			supply.setSupply_info(""); // 발주신청중이라 null
			template.insert("supply.insertSupply", supply); // 수불 생성
				
			for(int x = 0; x < sum.length; x++){
				sup = new SupplyListVo();
				sup.setSplylist_id(code.autoCode("SUP10", supply.getPlace_id())); // SUPPLY_LIST 코드
				sup.setSplylist_info("발주신청"); // 상품 내용
				sup.setSplylist_exdate(today); // 상품 유통기한
				sup.setSplylist_sum(sum[x]); // 상품 수량
				sup.setSupply_bcd(supply.getSupply_bcd()); // SUPPLY_BCD 코드
				sup.setProd_id(prod_id[x]); // 상품 아이디
				template.insert("supply.insertSupplyList", sup); // SUPPLY_LIST 생성	
			}
		}	
	}
	
	
	// 구매내역
	@Test
	public void payTest(){
		BookmarkVo bookmarkVo = null;
		String[] mem_id = { "kmk@ddit.or.kr", "kbk@ddit.or.kr",
							"ysy@ddit.or.kr", "ldj@ddit.or.kr", "lsb@ddit.or.kr",
							"ljh@ddit.or.kr", "cdl@ddit.or.kr", "bsa@ddit.or.kr",
							"ykm@ddit.or.kr", "syj@ddit.or.kr", "ysh@ddit.or.kr",
							"kjs@ddit.or.kr" };
		String kind = "111";
		String[] prod_id = { "necessities-00207", "necessities-00357",
							 "necessities-00431", "necessities-00456", "necessities-00946",
							 "necessities-00849" };
		for(int i = 0; i < mem_id.length; i++){			
			bookmarkVo = new BookmarkVo();
			bookmarkVo.setStar_id(code.autoCode("BOOKP", mem_id[i])); // 즐겨찾기 코드
			bookmarkVo.setMem_id(mem_id[i]);
			for(int j = 0; j < 2; j++){
				bookmarkVo.setStar_kind(kind);
				bookmarkVo.setProd_id(prod_id[j]);
				template.insert("bookmark.insertProdBookmark", bookmarkVo); // 즐겨찾기 제품 등록				
			}
		}
	}
}