<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/jstl-core.tld" prefix="core"%>
<%@ page import ="java.util.Date"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="org.apache.struts.upload.FormFile"%>
<%@ page import="com.ibank.ibanking.npsb.bo.NPSBEremitTransactionStatusUpdateBO"%>
<html>
<head>
<bean:message key="label.metaDescription"/>
<bean:message key="label.metaKeywords"/>
<bean:message key="label.metaAuthor"/>
<bean:message key="label.metaExpires"/>
<bean:message key="label.metaImagetoolbar"/>
<bean:message key="label.metaRating"/>
<bean:message key="label.metaGenerator"/>
<bean:message key="label.metaCopyright"/>
<bean:message key="label.metaRobots"/>
<bean:message key="label.metaRevisitAfter"/>
<bean:message key="label.metaPragma"/>
<bean:message key="label.metaDocRights"/>
<bean:message key="label.metaMSSmartTagsPreventParsing"/>
<bean:message key="label.metaLanguage"/>
<bean:message key="label.metaContentType"/>
<bean:message key="label.metaContentStyleType"/>
<bean:message key="label.iBankingTitle"/>
<link rel="stylesheet" href="pages/stylesheet/div-table.css" type="text/css">
<link rel="stylesheet" href="pages/assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="pages/stylesheet/style.css" type="text/css">
<link rel="stylesheet" href="pages/stylesheet/example.css" type="text/css">
<script language="JavaScript" src="<html:rewrite page='/pages/calender/CalendarPopup.js'/>"></script>
<script language="JavaScript" src="<html:rewrite page='/pages/javascript/tabber.js'/>"></script>
<link rel="stylesheet" href="pages/stylesheet/jquery-ui.css" type="text/css">
<script language="JavaScript" src="<html:rewrite page='/pages/javascript/jquery-1.9.1.js'/>"></script>
<script language="JavaScript" src="<html:rewrite page='/pages/javascript/jquery-ui.js'/>"></script>
<link rel="stylesheet" href="pages/stylesheet/1.12.1themesbasejquery-ui.css" type="text/css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script language="JavaScript">var cal = new CalendarPopup();</script>
<script language="javascript" type="text/javascript">
	function   setBodyProperty() {
  		document.oncontextmenu = function(){return false};
  		document.oncut = function(){return false};
		document.ondragstart = function(){return false};
  		document.ondrag = function(){return false};
	}
	$(document).ready(                   
		function () {	
			$("#datepicker").datepicker({
				//dateFormat: 'dd/mm/yy',//this option for formatting a Date
				dateFormat: 'ddmmyy',
				changeMonth: true, //this option for allowing user to select month
				changeYear: true, //this option for allowing user to select from year range
				yearRange: "-50:+50"
			});
			$("#datepicker1").datepicker({
				//dateFormat: 'dd/mm/yy',//this option for formatting a Date
				dateFormat: 'ddmmyy',
				changeMonth: true, //this option for allowing user to select month
				changeYear: true, //this option for allowing user to select from year range
				yearRange: "-50:+50"
			});	
	    }
   	);	
 	function doSearch(f){
		f.action="/ibanking/searchNPSBEremitTransactionStatusUpdate.do";
		f.submit();		
	}	
	function doClear(f){
		f.action="/ibanking/eremitDetailsOfNPSBTransactionStatusUpdate.do";
		f.submit();		
	}	
	function doClick(v1,v2,v3,v4,v5,v6){
		window.opener.document.nPSBEremitTransactionStatusUpdateForm.transactionID.value = v1;
		window.opener.document.nPSBEremitTransactionStatusUpdateForm.debitAcNo.value = v2;
		window.opener.document.nPSBEremitTransactionStatusUpdateForm.creditAcNo.value = v3;
		window.opener.document.nPSBEremitTransactionStatusUpdateForm.transactionAmount.value = v4;
		window.opener.document.nPSBEremitTransactionStatusUpdateForm.bankName.value = v5;
		window.opener.document.nPSBEremitTransactionStatusUpdateForm.transactionDate.value = v6;
        		
		window.close();
		
	}	
	                       

	
</script>
<style type="text/css">
.hiddenDiv {
	display: none;
}
.visibleDiv {
	display: block;
}
.show {
	display: compact;
}
.hideRow {
	display: none;
}
tr.spaceUnder>td {
	padding-bottom: 0.3em !important;
}
.ui-datepicker {
	background: #94A3DC;
	border: 1px solid #555;
	color: #EEE;
}
#table_box {
	width: 100%;
	font-size: 13px;
	border-collapse: collapse;
	text-align: center;
}
#table_box th {
	padding: 7px;
	color: #292929;
}
#table_box td {
	padding: 4px 0 4px 0;
	color: #464646;
	border: 1px solid #cecece;
}
.maintb th {
	background-color: #174797;
	color: #FFF!important;
	text-align: center;
}
#table_box tr:nth-child(odd) {
	background-color: #ffffff
} /*odd*/
#table_box tr:nth-child(even) {
	background-color: #e6e6e6
} /* even*/
#table_box tr:hover {
	background-color: #fffbae;
} /* hovering */
</style>
<style>
.tabletrtd {
 cellpadding= 3;
 cellspacing= 1;
}
.modelul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	border: 1px solid black;
}
.modelli {
	float: left;
}
.modelli {
	display: block;
	color: #000;
	padding: 16px;
	text-decoration: none;
}
.modalHeight {
	padding-top: 60px !important;
}
.modal-header {
	background-color: #103370 !important;
	color: #FFF !important;
}
.body-clr {
	background-color: #e6e6e6 !important;
}
#modal-terms-label {
	color: #FFF;
}
</style>
</head>
<body onLoad="setBodyProperty()">
<html:form action="/eremitDetailsOfNPSBTransactionStatusUpdate" enctype="multipart/form-data" style="margin: 0">
  <table style="width: 100%; height: 100%" border: "0">
    <tr>
      <html:hidden property="serialNo"/>
      <html:hidden property="status"/>
      <td style="height: 50"><table style="width: 100%; border: 0">
          <tr>
            <td colspan="3"><table style="width: 100%; border: 0">
                <tr>
                  <td width="1%">&nbsp;</td>
                  <td width="98%"><table style="width: 100%; border: 0" cellpadding="3" cellspacing="1" >
                      <tr>
                        <td rowspan="3" align="center" class="msg-00"><strong>
                          <%out.print(session.getAttribute("oNPSBOutgoingReversalMessageBO"));%>
                          </strong></td>
                      </tr>
                    </table></td>
                  <td width="1%">&nbsp;</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
    </tr>
    <tr>
      <td valign="top"><table style="width: 100%; border: 0">
           <tr class="spaceUnder">
            <td width="2%"></td>
            <td width="20%" align="right" class="lbl-n">From Date</td>
            <td width="2%">&nbsp;</td>
            <td width="25%"><html:text property="fromDate" styleClass="txt-n" style="width:210px" styleId="datepicker"/></td>
            <td width="2%"></td>
           
          </tr>
          <tr class="spaceUnder">
            <td></td>
            <td align="right" class="lbl-n">To Date</td>
            <td>&nbsp;</td>
            <td><html:text property="toDate" styleClass="txt-n" style="width:210px" styleId="datepicker1"/></td>
            <td></td>
           
          </tr>
           
           <tr>
           <td colspan="9"><a href="#" onClick="doSearch(nPSBEremitTransactionStatusUpdateForm)"><font class="btn">Search</font></a><font class="usr-1">
              <bean:message key="label.|"/>
              </font> <a href="#" onClick="doClear(nPSBEremitTransactionStatusUpdateForm)"><font class="btn">Clear</font></a></td>
          </tr>
          <tr>
            <td colspan="9"><table style="width: 100%; border: 0px;" >
                <tr>
                  <td colspan="10"><table style="width: 100%" border="1" id="table_box" class="maintb" align="center">
                      <tr bgcolor="#99CCCC">
            <!--        <th width="4%" align="center" valign="middle" class="lbl-b-08"  style="height: 35">Srl</th>-->
                        <th width="13%" align="right" valign="middle"  class="lbl-b-08">Transaction ID</th>
                        <th width="13%" align="right" valign="middle"  class="lbl-b-08">Debit Account No</th>
                        <th width="14%" align="center" valign="middle" class="lbl-b-08">Credit Account No</th>
                        <th width="8%"  align="center" valign="middle" class="lbl-b-08">Transaction Amount</th>
                        <th width="17%" align="center" valign="middle"  class="lbl-b-08">Bank Name</th>
                        <th width="9%" align="center" valign="middle" class="lbl-b-08">Transaction Date</th>                      
                        <th width="4%"  align="center" valign="middle" class="lbl-b-08">&nbsp;</th>
                      </tr>
                      <core:forEach var="indexCustomerList" items="${sessionScope['oNPSBEremitTransactionStatusUpdateBO'].reversalList}">
                        <tr bgcolor="#99CCFF">
              <!--                <td valign="top" class="lbl-08"  align="center"><core:out value="${indexCustomerList.serialNo}"/></td>-->
                          <td valign="top" class="lbl-08" align="center"><core:out value="${indexCustomerList.transactionID}"/></td>
                          <td valign="top" class="lbl-08" align="center"><core:out value="${indexCustomerList.debitAcNo}"/></td>
                          <td valign="top" class="lbl-08" align="center"><core:out value="${indexCustomerList.creditAcNo}"/></td>
                          <td valign="top" class="lbl-08" align="right"><core:out value="${indexCustomerList.transactionAmount}"/></td>
                          <td valign="top" class="lbl-08" align="right"><core:out value="${indexCustomerList.bankName}"/></td>                        
                          <td align="right" valign="top" class="lbl-08"><core:out value="${indexCustomerList.transactionDate}"/></td>              
                          <td align="center" valign="top" class="lbl-08"><a href="#" onClick="doClick('${indexCustomerList.transactionID}','${indexCustomerList.debitAcNo}','${indexCustomerList.creditAcNo}','${indexCustomerList.transactionAmount}','${indexCustomerList.bankName}','${indexCustomerList.transactionDate}')">
                       select</a></td>
                        </tr>
                      </core:forEach>
                    </table></td>
                </tr>
              </table></td>
          </tr>
        </table></td>
    </tr>
    <div class="modal fade" id="confirm-submit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-sm">
        <div class="modal-content">
          <div class="modal-header" style="background-color:#FFF; font-weight:bold"> Wait ! </div>
          <div class="modal-body"> Are you sure you want to submit ? </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
            <a href="#" onClick="doExecute()" class="btn btn-success success">Submit</a> </div>
        </div>
      </div>
    </div>
    <div class="modal fade" id="confirm-logout" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-sm">
        <div class="modal-content">
          <div class="modal-header"> Wait ! </div>
          <div class="modal-body"> Are you sure? If you confirm press Log Out button </div>
          <div class="modal-footer"> <a href="#" onClick="doLogOut()" class="btn btn-success success">Log Out</a>
            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
          </div>
        </div>
      </div>
    </div>
    <tr>
      <td><table style="width: 100%; border: 0">
          <tr>
            <td colspan="2" valign="middle" class="lbl-cb" align="center"><bean:message key="label.copyright"/></td>
          </tr>
        </table></td>
    </tr>
  </table>
</html:form>
<script src="pages/assets/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
