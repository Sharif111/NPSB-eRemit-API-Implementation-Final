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
				dateFormat: 'dd/mm/yy',//this option for formatting a Date
				changeMonth: true, //this option for allowing user to select month
				changeYear: true, //this option for allowing user to select from year range
				yearRange: "-50:+50"
			});			
	    }
   	);
	function doMainMenu(f){
		f.action="/ibanking/cancelNPSBEremitTransactionStatusUpdate.do";
		f.submit();
	}
	function doLogOut(){
		var f = document.nPSBEremitTransactionStatusUpdateForm;	
			f.action="/ibanking/logOutIBanking.do";
			f.submit();		
	}	
	function doExecute(f){
		f.action="/ibanking/executeNPSBEremitTransactionStatusUpdate.do";
		f.submit();		
	}	
	function doClear(f){
		f.action="/ibanking/nPSBEremitTransactionStatusUpdate.do";
		f.submit();
	}		
 	/*function getReversalInfo(e,f){
		if(window.event){e = window.event}	
		if(e.keyCode==13){
			f.action="/ibanking/reversalDetailsOfNPSBOutgoingReversal.do";
			f.submit();		
		}
	}*/
	function openWinForsourceAccountInfo(){
		winURL ="eremitDetailsOfNPSBTransactionStatusUpdate.do?";
		winName = "NPSBeRemitTransactionStatusUpdate";
		winHeight = 470;
		winWidth =1200;
		winTop = ((screen.availHeight/2) - (winHeight / 3));
		winLeft = ((screen.availWidth/2) - (winWidth / 2));
		winOpen = "";
			
		if(winOpen){
			if(winOpen.closed){
				winOpen = window.open(winURL, winName, "top=" + winTop + ",left=" + winLeft + ",width=" + winWidth + ",height=" + winHeight + ",resizable=no,toolbar=no,scrollbars=yes,location=no,status=no,menubar=no")
			} else { 
				winOpen.close();
				winOpen = window.open(winURL, winName, "top=" + winTop + ",left=" + winLeft + ",width=" + winWidth + ",height=" + winHeight + ",resizable=no,toolbar=no,scrollbars=yes,location=no,status=no,menubar=no")
			}
		} else {
			winOpen = window.open(winURL, winName, "top=" + winTop + ",left=" + winLeft + ",width=" + winWidth + ",height=" + winHeight + ",resizable=no,toolbar=no,scrollbars=yes,location=no,status=no,menubar=no")
		}
		winOpen.focus();
	}
</script>


<style>
tr.spaceUnder>td {
  padding-bottom: 0.3em !important;
}
.ui-datepicker {
    background: #94A3DC;
    border: 1px solid #555;
    color: #EEE;
}
.modalHeight{	
	padding-top:60px !important;	
}	
.modal-header{	
	background-color:#103370 !important;
	color:#FFF !important;	
}
.body-clr{	
	background-color:#e6e6e6 !important;	
}	
#modal-terms-label{	
	color:#FFF;
}
</style>

</head>
<body onLoad="setBodyProperty()">
<html:form action="/nPSBEremitTransactionStatusUpdate" enctype="multipart/form-data" style="margin: 0">
  <table style="width: 100%; height: 100%" border: "0"> 
    <tr>
     <html:hidden property="status"/>
      <td style="height: 50"><table style="width: 100%; border: 0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="8%" valign="top"><bean:message key="label.myBankHeaderLogo"/></td>
                  <td width="92%" class="myBankHeader"><table width="100%" border="0" cellspacing="3" cellpadding="0">
                      <tr>
                        <td width="7%" align="left" valign="top" class="usr-6">&nbsp;</td>
                        <td width="70%" align="center" valign="top" class="usr-6"><%out.print(session.getAttribute("GSCompanyName"));%></td>
                        <td width="16%" align="right" valign="top"><font class="usr-5"> Operation ID : </font></td>
                        <td width="7%" align="left" valign="top"><font class="usr-1"><%out.print(session.getAttribute("GSTellerID"));%></font></td>
                      </tr>
                      
                      <tr>
                        <td  align="left" valign="top" class="usr-4">&nbsp;</td>
                        <td align="center" valign="top"><font class="usr-4"><span id="BranchName"></span></font></td>
                        <td align="right" valign="top"><font class="usr-5"> Open Date : </font></td>
                        <td align="left" valign="top"><font class="usr-1"><%out.print(session.getAttribute("GSBranchOpenDateDDFormat"));%></font></td>
                      </tr>
                      
                      <tr>
                        <td height="21" align="left" valign="top">&nbsp;</td>
                           <td align="center" valign="top"><font class="usr-6">System Admin</font><font class="usr-1">
                          <bean:message key="label.-"/>
                          </font><font class="usr-4">NPSB eRemit Transaction Status Update</font></td>
                        <td colspan="2" align="right" valign="top"><a href="#" onClick="doMainMenu(nPSBEremitTransactionStatusUpdateForm)"><font class="usr-5">
                          <bean:message key="label.mainMenu"/>
                          </font></a> <font class="usr-1">
                          <bean:message key="label.|"/>
                          </font> <a href="#" value="Submit"  data-toggle="modal" data-target="#confirm-logout" ><font class="usr-5">
                          <bean:message key="label.signOut"/>
                          </font></a></td>
                      </tr>
                      
                    </table></td>
                </tr>
              </table></td>
          </tr>
           <tr>
            <td colspan="2" valign="top"><a href="#" ><font class="btn">
          
              </font></a> <font class="usr-1">            
              </font><a href="#" > <font class="btn">         
              </font></a> </td>
          </tr>
         
          <tr>
            <td colspan="3"><table style="width: 100%; border: 0">
                <tr>
                  <td width="1%">&nbsp;</td>
                  <td width="98%"><table style="width: 100%; border: 0" cellpadding="3" cellspacing="1" >

                      <tr>
                        <td rowspan="3" align="center" class="msg-00"><strong><%out.print(session.getAttribute("oNPSBOutgoingReversalMessageBO"));%></strong></td>
                      </tr>
           
                    </table></td>
                  <td width="1%">&nbsp;</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
    </tr>
    
    
    <tr>
      <td valign="top">
          <table style="width: 100%; border: 0">
              <tr>
                <td><table style="width: 100%; border: 0px;" cellpadding="3" cellspacing="1" >
                
          <tr>
            <td width="20%">&nbsp;</td>
            <td width="22%">&nbsp;</td>
            <td width="2%">&nbsp;</td>
            <td width="45%">&nbsp;</td>
            <td width="11%">&nbsp;</td>
            </tr>
            <tr class="spaceUnder">
            <td height="29">&nbsp;</td>
            <td align="right" class="lbl-n">Transaction ID</td>
            <td>&nbsp;</td>
            <td><html:text property="transactionID" styleClass="txt-c" readonly="true" style="width:210px"/>  
            <a href="#" onClick="openWinForsourceAccountInfo()">
              <bean:message key="label.searchImage"/>
              </a></td>
            <td>&nbsp;</td>
            </tr>
            <tr class="spaceUnder">
            <td height="29">&nbsp;</td>
            <td align="right" class="lbl-n">Debit Account No</td>
            <td>&nbsp;</td>
            <td><html:text property="debitAcNo" styleClass="txt-c" readonly="true" style="width:210px"/></td>
            <td>&nbsp;</td>
            </tr>
            <tr class="spaceUnder">
            <td height="29">&nbsp;</td>
            <td align="right" class="lbl-n">Credit Account No</td>
            <td>&nbsp;</td>
            <td><html:text property="creditAcNo" styleClass="txt-c" readonly="true" style="width:210px"/></td>
            <td>&nbsp;</td>
            </tr>
            <tr class="spaceUnder">
            <td height="29">&nbsp;</td>
            <td align="right" class="lbl-n">Transaction Amount</td>
            <td>&nbsp;</td>
            <td><html:text property="transactionAmount" styleClass="txt-c" readonly="true" style="width:210px"/></td>
            <td>&nbsp;</td>
            </tr>
            <tr class="spaceUnder">
            <td height="29">&nbsp;</td>
            <td align="right" class="lbl-n">Bank Name</td>
            <td>&nbsp;</td>
            <td><html:text property="bankName" styleClass="txt-c" readonly="true" style="width:210px"/></td>
            <td>&nbsp;</td>
            </tr>
            </tr>
            <tr class="spaceUnder">
            <td height="29">&nbsp;</td>
            <td align="right" class="lbl-n">Transaction Date</td>
            <td>&nbsp;</td>
            <td><html:text property="transactionDate" styleClass="txt-c" readonly="true" style="width:210px"/></td>
            <td>&nbsp;</td>
            </tr>
          <tr class="spaceUnder">
            <td height="29">&nbsp;</td>
            <td align="right" class="lbl-n">Status</td>
            <td>&nbsp;</td>
            <td><html:select property="userStatus" styleClass="txt-n" style="width:210px">
                      <html:option value="" styleClass="txt-n">
                        <bean:message key="label.pleaseSelect"/>
                      </html:option>
                      <html:options property="userStatusList" styleClass="txt-n" labelProperty="userStatusNameList"/>
                    </html:select></td>
            <td>&nbsp;</td>
            </tr>
          
          <tr class="spaceUnder">
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            </tr>
                    
          <tr class="spaceUnder">
           
            <td align="left">&nbsp;</td>
            <td align="left">&nbsp;</td>
            <td align="left">&nbsp;</td>
             <td align="left"><input type="button" value="Update" style="color:#03F" data-toggle="modal" data-target="#confirm-submit" id="exeButton" />
            <input type="button" value="Clear" style="color:#03F;width:70px;margin-right:74px" name="sendMail" onClick="doClear(nPSBEremitTransactionStatusUpdateForm)" /></td>
            <td align="left">&nbsp;</td>
            </tr>                
                
 		 <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td  class="lbl-n"></td>
            </tr>
          
         </table></td>
        </tr>
       </table>
      </div>          
     </td>
    </tr>
       
    
  <div class="modal fade" id="confirm-submit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header" style="background-color:#FFF; font-weight:bold">
               Wait !
            </div>
            
            <div class="modal-body">
                Are you sure you want to Reverse?
           </div>

  <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
            <a href="#" onClick="doExecute(nPSBEremitTransactionStatusUpdateForm)" class="btn btn-success success">Submit</a>
        </div>
    </div>
  </div>
</div>


<div class="modal fade" id="confirm-logout" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
              Wait !
            </div>
            <div class="modal-body">
               Are you sure? If you confirm press Log Out button
           </div>

  <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
            <a href="#" onClick="doLogOut()" class="btn btn-success success">Log Out</a>
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
