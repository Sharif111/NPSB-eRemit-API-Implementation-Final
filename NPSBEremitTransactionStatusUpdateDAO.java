package com.ibank.ibanking.npsb.dao;

import com.ibank.dbconnection.application.DBCPNewConnection;
import com.ibank.ibanking.npsb.bo.NPSBEremitTransactionStatusUpdateBO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;


public class NPSBEremitTransactionStatusUpdateDAO {

	SimpleDateFormat sSimpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

	public NPSBEremitTransactionStatusUpdateBO getPermissionCheckPro(String sUserID, String sSessionID,
			String sCompanyID, String sBranchID, String sIPAddress, String sBranchActionPath) throws Exception {
		Connection oConn = null;
		oConn = DBCPNewConnection.getConnection();
		NPSBEremitTransactionStatusUpdateBO oNPSBEremitTransactionStatusUpdateBO = new NPSBEremitTransactionStatusUpdateBO();
		CallableStatement oStmt = oConn.prepareCall("{call MyBank.DPR_MYBANK_BANK_USER_CHECK(?,?,?,?,?,?,?)}");
		oStmt.setString(1, sUserID);
		oStmt.setString(2, sSessionID);
		oStmt.setString(3, sCompanyID);
		oStmt.setString(4, sBranchID);
		oStmt.setString(5, sIPAddress);
		oStmt.setString(6, sBranchActionPath);
		oStmt.registerOutParameter(7, 4);

		try {
			oStmt.execute();
			oNPSBEremitTransactionStatusUpdateBO.setErrorCode("" + oStmt.getInt(7));
		} catch (Exception var17) {
			var17.printStackTrace();

			try {
				oConn.rollback();
			} catch (Exception var16) {
			}
		} finally {
			if (oStmt != null) {
				oStmt.close();
			}

			DBCPNewConnection.releaseConnection(oConn);
		}

		return oNPSBEremitTransactionStatusUpdateBO;
	}

	public NPSBEremitTransactionStatusUpdateBO getMenuCheckPro(String sUserID, String sSessionID, String sCompanyID,
			String sBranchID, String sRemoteIPAddress, String sActionPath) throws Exception {
		Connection oConn = null;
		oConn = DBCPNewConnection.getConnection();
		NPSBEremitTransactionStatusUpdateBO oNPSBEremitTransactionStatusUpdateBO = new NPSBEremitTransactionStatusUpdateBO();
		CallableStatement oStmt = oConn.prepareCall("{call IBANKING.dpr_ibk_main_menu_check(?,?,?,?,?,?,?,?)}");
		oStmt.setString(1, sUserID);
		oStmt.setString(2, sSessionID);
		oStmt.setString(3, sCompanyID);
		oStmt.setString(4, sBranchID);
		oStmt.setString(5, sRemoteIPAddress);
		oStmt.setString(6, sActionPath);
		oStmt.registerOutParameter(7, 4);
		oStmt.registerOutParameter(8, 12);

		try {
			oStmt.execute();
			oNPSBEremitTransactionStatusUpdateBO.setErrorCode("" + oStmt.getInt(7));
			oNPSBEremitTransactionStatusUpdateBO.setErrorMessage(oStmt.getString(8));
		} catch (Exception var17) {
			var17.printStackTrace();

			try {
				oConn.rollback();
			} catch (Exception var16) {
			}
		} finally {
			DBCPNewConnection.releaseConnection(oConn);
		}

		return oNPSBEremitTransactionStatusUpdateBO;
	}

	public NPSBEremitTransactionStatusUpdateBO getSessionCheckPro(String sUserID, String sSessionID, String sCompanyID,
			String sBranchID) throws Exception {
		Connection oConn = null;
		oConn = DBCPNewConnection.getConnection();
		NPSBEremitTransactionStatusUpdateBO oNPSBEremitTransactionStatusUpdateBO = new NPSBEremitTransactionStatusUpdateBO();
		CallableStatement oStmt = oConn.prepareCall("{CALL MYBANK.DPR_SESSION_VERIFY(?,?,?,?,?)}");
		oStmt.setString(1, sUserID);
		oStmt.setString(2, sSessionID);
		oStmt.setString(3, sCompanyID);
		oStmt.setString(4, sBranchID);
		oStmt.registerOutParameter(5, 4);

		try {
			oStmt.execute();
			oNPSBEremitTransactionStatusUpdateBO.setErrorCode("" + oStmt.getInt(5));
		} catch (Exception var15) {
			var15.printStackTrace();

			try {
				oConn.rollback();
			} catch (Exception var14) {
			}
		} finally {
			if (oStmt != null) {
				oStmt.close();
			}

			DBCPNewConnection.releaseConnection(oConn);
		}

		return oNPSBEremitTransactionStatusUpdateBO;
	}

	public NPSBEremitTransactionStatusUpdateBO getMessageInformation(String sUserID, String sSessionID)
			throws Exception {
		Connection oConn = null;
		Statement oStmt = null;
		ResultSet oRs = null;
		ArrayList aTmpList = new ArrayList();
		oConn = DBCPNewConnection.getConnection();
		oStmt = oConn.createStatement();
		new StringBuffer();
		NPSBEremitTransactionStatusUpdateBO oNPSBEremitTransactionStatusUpdateBO = new NPSBEremitTransactionStatusUpdateBO();

		try {
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT NVL(ERRMSG,' ')");
			sql.append("FROM MyBank.SY_MESSAGE ");
			sql.append("WHERE MAILID = '");
			sql.append(sUserID);
			sql.append("' AND SESSIONID = '");
			sql.append(sSessionID);
			sql.append("' ORDER BY SERNUM ");
			oRs = oStmt.executeQuery(sql.toString());

			while (oRs.next()) {
				NPSBEremitTransactionStatusUpdateBO oLoanDisbursementListBO = new NPSBEremitTransactionStatusUpdateBO();
				oLoanDisbursementListBO.setErrorMessage(oRs.getString(1));
				aTmpList.add(oLoanDisbursementListBO);
			}

			oNPSBEremitTransactionStatusUpdateBO.setList(aTmpList);
		} catch (Exception var13) {
			var13.printStackTrace();
		} finally {
			if (oRs != null) {
				oRs.close();
			}

			if (oStmt != null) {
				oStmt.close();
			}

			DBCPNewConnection.releaseConnection(oConn);
		}

		return oNPSBEremitTransactionStatusUpdateBO;
	}

	public NPSBEremitTransactionStatusUpdateBO getMenuList(String sUserID, String sSessionID) throws Exception {
		NPSBEremitTransactionStatusUpdateBO oNPSBEremitTransactionStatusUpdateBO = new NPSBEremitTransactionStatusUpdateBO();
		Connection oConn = null;
		Statement oStmt = null;
		oConn = DBCPNewConnection.getConnection();
		oStmt = oConn.createStatement();
		ArrayList aMenuList = new ArrayList();
		ArrayList aMenuNameList = new ArrayList();
		ResultSet oRs = null;
		new StringBuffer();

		try {
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT NVL(URL,' '), NVL(NODENAME,' ')");
			sql.append("FROM MyBank.SY_FAVORITES ");
			sql.append("WHERE MAILID = '");
			sql.append(sUserID);
			sql.append("' AND SESSIONID = '");
			sql.append(sSessionID);
			sql.append("' ORDER BY SERNUM ");
			oRs = oStmt.executeQuery(sql.toString());

			while (oRs.next()) {
				aMenuList.add(oRs.getString(1));
				aMenuNameList.add(oRs.getString(2));
			}

			oNPSBEremitTransactionStatusUpdateBO.setMenuList(aMenuList);
			oNPSBEremitTransactionStatusUpdateBO.setMenuNameList(aMenuNameList);
		} catch (Exception var17) {
			var17.printStackTrace();

			try {
				oConn.rollback();
			} catch (Exception var16) {
			}
		} finally {
			if (oStmt != null) {
				oStmt.close();
			}

			if (oRs != null) {
				oRs.close();
			}

			DBCPNewConnection.releaseConnection(oConn);
		}

		return oNPSBEremitTransactionStatusUpdateBO;
	}

	public NPSBEremitTransactionStatusUpdateBO getNPSBOutgoingReversalInfoPro(String sUserID, String sSessionID,
			String sCompanyID, String sOperationMode, String sFromDate, String sToDate, String sStatus,
			String sSourceAccount, String sDestinationAccount, String sAmount) throws Exception {
		Connection oConn = null;
		oConn = DBCPNewConnection.getConnection();
		NPSBEremitTransactionStatusUpdateBO oNPSBEremitTransactionStatusUpdateBO = new NPSBEremitTransactionStatusUpdateBO();
		CallableStatement oStmt = oConn
				.prepareCall("{call IBANKING.dpr_ccard_outgoing_rev_inf(?,?,?,?,?,?,?,?,?,?,?,?)}");
		oStmt.setString(1, sUserID);
		oStmt.setString(2, sSessionID);
		oStmt.setString(3, sCompanyID);
		oStmt.setString(4, sOperationMode);
		oStmt.setString(5, sFromDate);
		oStmt.setString(6, sToDate);
		oStmt.setString(7, sStatus);
		oStmt.setString(8, sSourceAccount);
		oStmt.setString(9, sDestinationAccount);
		oStmt.setString(10, sAmount);
		oStmt.registerOutParameter(11, 4);
		oStmt.registerOutParameter(12, 12);

		try {
			oStmt.execute();
			oNPSBEremitTransactionStatusUpdateBO.setErrorCode("" + oStmt.getInt(11));
			oNPSBEremitTransactionStatusUpdateBO.setErrorMessage(oStmt.getString(12));
		} catch (Exception var21) {
			var21.printStackTrace();

			try {
				oConn.rollback();
			} catch (Exception var20) {
			}
		} finally {
			if (oStmt != null) {
				oStmt.close();
			}

			DBCPNewConnection.releaseConnection(oConn);
		}

		return oNPSBEremitTransactionStatusUpdateBO;
	}

	public NPSBEremitTransactionStatusUpdateBO getNPSBOutgoingReversalInfoData(String sUserID, String sSessionID)
			throws Exception {
		Connection oConn = null;
		Statement oStmt = null;
		ResultSet oRs = null;
		ArrayList aTmpList = new ArrayList();
		oConn = DBCPNewConnection.getConnection();
		oStmt = oConn.createStatement();
		new StringBuffer();
		NPSBEremitTransactionStatusUpdateBO oNPSBEremitTransactionStatusUpdateBO = new NPSBEremitTransactionStatusUpdateBO();

		try {
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT SERNUM, ");
			sql.append("NVL (AMOUNT, '') RRN_NUMBER,");
			sql.append("NVL (REFDAT, '') TRAN_DATE,");
			sql.append("NVL (BRANCD, '') SOURCE_ACC, ");
			sql.append("NVL (ACSTAT,'') SOURCE_ACC_TITLE,");
			sql.append("NVL (ACTYPE, '') DEST_ACC,");
			sql.append("NVL (ACTNUM, 0) TRAN_AMT, ");
			sql.append("NVL (CURDES, 0) DEBIT_DOCUMENT_NO, ");
			sql.append("NVL (EBNNAM, 0) REASON, ");
			sql.append("NVL (ACTTIT, '') TRAN_STATUS  ");
			sql.append("FROM IBANKING.DT_ACTLIST   ");
			sql.append("WHERE MAILID = '");
			sql.append(sUserID);
			sql.append("' AND SESSIONID = '");
			sql.append(sSessionID);
			sql.append("' ORDER BY SERNUM ");
			oRs = oStmt.executeQuery(sql.toString());

			while (oRs.next()) {
				NPSBEremitTransactionStatusUpdateBO oNPSBOutgoingReversalReverseListBO = new NPSBEremitTransactionStatusUpdateBO();
				oNPSBOutgoingReversalReverseListBO.setSerialNo(oRs.getString(1));
				oNPSBOutgoingReversalReverseListBO.setRRNNo(oRs.getString(2));
				oNPSBOutgoingReversalReverseListBO.setTransactionDate(oRs.getString(3));
				oNPSBOutgoingReversalReverseListBO.setSourceAccount(oRs.getString(4));
				oNPSBOutgoingReversalReverseListBO.setAccountTile(oRs.getString(5));
				oNPSBOutgoingReversalReverseListBO.setDestinationAccount(oRs.getString(6));
				oNPSBOutgoingReversalReverseListBO.setTransactionAmount(oRs.getString(7));
				oNPSBOutgoingReversalReverseListBO.setDebitDocNo(oRs.getString(8));
				oNPSBOutgoingReversalReverseListBO.setReason(oRs.getString(9));
				oNPSBOutgoingReversalReverseListBO.setStatus(oRs.getString(10));
				aTmpList.add(oNPSBOutgoingReversalReverseListBO);
			}

			oNPSBEremitTransactionStatusUpdateBO.setReversalList(aTmpList);
		} catch (Exception var13) {
			var13.printStackTrace();
		} finally {
			if (oRs != null) {
				oRs.close();
			}

			if (oStmt != null) {
				oStmt.close();
			}

			DBCPNewConnection.releaseConnection(oConn);
		}

		return oNPSBEremitTransactionStatusUpdateBO;
	}

	public NPSBEremitTransactionStatusUpdateBO getExecutePro(String sUserID, String sSessionID, String sCompanyID,
			String sOperationMode, String sDocumentNo, String sAccountNo, String sTransactionDate, String sStatus)
			throws Exception {
		Connection oConn = null;
		oConn = DBCPNewConnection.getConnection();
		NPSBEremitTransactionStatusUpdateBO oNPSBEremitTransactionStatusUpdateBO = new NPSBEremitTransactionStatusUpdateBO();
		CallableStatement oStmt = oConn.prepareCall("{call IBANKING.DPR_NPS_OUTGOING_REV_EXE(?,?,?,?,?,?,?,?,?,?)}");
		oStmt.setString(1, sUserID);
		oStmt.setString(2, sSessionID);
		oStmt.setString(3, sCompanyID);
		oStmt.setString(4, sOperationMode);
		oStmt.setString(5, sDocumentNo);
		oStmt.setString(6, sAccountNo);
		oStmt.setString(7, sTransactionDate);
		oStmt.setString(8, sStatus);
		oStmt.registerOutParameter(9, 4);
		oStmt.registerOutParameter(10, 12);

		try {
			oStmt.execute();
			oNPSBEremitTransactionStatusUpdateBO.setErrorCode("" + oStmt.getInt(9));
			oNPSBEremitTransactionStatusUpdateBO.setErrorMessage(oStmt.getString(10));
		} catch (Exception var19) {
			var19.printStackTrace();

			try {
				oConn.rollback();
			} catch (Exception var18) {
			}
		} finally {
			if (oStmt != null) {
				oStmt.close();
			}

			DBCPNewConnection.releaseConnection(oConn);
		}

		return oNPSBEremitTransactionStatusUpdateBO;
	}
	public NPSBEremitTransactionStatusUpdateBO getStatusListData( String sUserID,String sSessionID)		throws Exception {

		NPSBEremitTransactionStatusUpdateBO oNPSBEremitTransactionStatusUpdateBO = new NPSBEremitTransactionStatusUpdateBO();
		Connection oConn = null;
		Statement oStmt = null;
		oConn = DBCPNewConnection.getConnection();
		oStmt = oConn.createStatement();
		ArrayList aStatusList = new ArrayList();
		ArrayList aStatusNameList = new ArrayList();
		ResultSet oRs = null;
		StringBuffer sql = new StringBuffer();
		try {
			sql = new StringBuffer();
			sql.append("SELECT ACTYPE,ACDESC FROM IBANKING.LK_PARAMETER WHERE ACTCOD ='npsb_eremit_api_status' ORDER BY SERNUM ");
			oRs = oStmt.executeQuery(sql.toString());
			while (oRs.next()) {
				aStatusList.add(oRs.getString(1));
				aStatusNameList.add(oRs.getString(2));
			}
			oNPSBEremitTransactionStatusUpdateBO.setUserStatusList(aStatusList);
			oNPSBEremitTransactionStatusUpdateBO.setUserStatusNameList(aStatusNameList);
		} catch (Exception sq) {
			sq.printStackTrace();
			try {
				oConn.rollback();
			} catch (Exception E) {
			}
		} finally {
			if (oStmt != null) {
				oStmt.close();
			}
			if (oRs != null) {
				oRs.close();
			}
			DBCPNewConnection.releaseConnection(oConn);
		}
		return oNPSBEremitTransactionStatusUpdateBO;
	}

	public NPSBEremitTransactionStatusUpdateBO getNPSBeRemitAPI(NPSBEremitTransactionStatusUpdateBO model) {
		
		
		NPSBEremitTransactionStatusUpdateBO oNPSBEremitTransactionStatusUpdateBO = new NPSBEremitTransactionStatusUpdateBO();
		String responseString = "";

		try {
			JSONObject json = new JSONObject();
			json.put("username", "npsbuser");
			json.put("password", "Bankasia#2021");

			String jsonString = json.toString();
			System.out.println("jsonString = " + jsonString);

			String url = "http://192.168.155.16:83/api/customer/tokenForExHouse";
			System.out.println("url = " + url);

			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpPost httppost = new HttpPost(url);
			JSONObject jsonObject = new JSONObject(jsonString);

			StringEntity enttity = new StringEntity(String.valueOf(jsonObject));
			httppost.addHeader("content-type", "application/json");
			httppost.setEntity(enttity);

			CloseableHttpResponse httpResponse = httpClient.execute(httppost);

			int status = httpResponse.getStatusLine().getStatusCode();
			System.out.println("status => " + status);

			if (status == 200) {
				System.out.println("status = " + status);
				responseString = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
				System.out.println("response = " + responseString);

				JSONObject obj = new JSONObject(responseString);
				System.out.println("obj = " + obj);

				String apiData = "";
				String token = "";

				if (obj.has("apiData") && !obj.isNull("apiData")) {
					org.json.JSONObject apiDataObj = obj.getJSONObject("apiData");
					System.out.println("apiData = " + apiDataObj);
					if (apiDataObj.has("token") && !apiDataObj.isNull("token")) {
						token = apiDataObj.getString("token");
					}
				}
				System.out.println("token = " + token);
				
				if(token != "") {
					model.setKeyId(token);
					model.setErrorCode("0");
					model.setErrorMessage("Get token successfully" );
					return model;
				}else {
					model.setErrorCode("1");
					model.setErrorMessage("Token is Empty" );
					return model;
				}				


			} else {
				model.setErrorCode("1");
				model.setErrorMessage("NPSB eRemit API does not response " + status);
			}

		} catch (Exception var17) {
			model.setErrorCode("1");
			model
					.setErrorMessage("Server not Found.. Please check Internet Connection...");
		}
		return model;
	}

	public NPSBEremitTransactionStatusUpdateBO responseNPSBeRemitAPI(NPSBEremitTransactionStatusUpdateBO model) {
		

		String responseString = "";		
		ArrayList aTmpList = new ArrayList();
		
		 NPSBEremitTransactionStatusUpdateBO oNPSBEremitTransactionStatusUpdateBO = new NPSBEremitTransactionStatusUpdateBO();


		try {

			System.out.println("responseNPSBeRemitAPI key ==>>> " + model.getKeyId());

			String url = "http://192.168.155.16:83/api/NPSB/getNPSBHoldData/" + model.getFromDate() + "/"
					+ model.getToDate();
			System.out.println("url = " + url);

			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet httppost = new HttpGet(url);

			httppost.addHeader("Authorization", "Bearer " + model.getKeyId());		

			CloseableHttpResponse httpResponse = httpClient.execute(httppost);

			int status = httpResponse.getStatusLine().getStatusCode();

			System.out.println("httpResponse => " + status);

			if (status == 200) {

				responseString = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
				System.out.println("response = " + responseString);

				JSONObject obj = new JSONObject(responseString);
				System.out.println("obj => " + obj);

				
				String transactionID = "";
				String debitAcNo = "";
				String creditAcNo = "";
				String transactionAmount = "";
				String bankName = "";
				String transactionDate = "";				
				String serialNo = "";
				String message ="";
								
				org.json.JSONArray apiDataObj = null;
				
				if (obj.has("apiData") && !obj.isNull("apiData")) {
					 apiDataObj = obj.getJSONArray("apiData");
					 System.out.println("apiDataObj = " +apiDataObj);
					 
					for (int i = 0; i < apiDataObj.length(); i++) {
						JSONObject jsonObject = apiDataObj.getJSONObject(i);
						System.out.println("jsonObject = " + jsonObject);
						
						if (jsonObject.has("transactionID") && !jsonObject.isNull("transactionID")) {
							transactionID = jsonObject.getString("transactionID");
						}

						if (jsonObject.has("drAccountNo") && !jsonObject.isNull("drAccountNo")) {
							debitAcNo = jsonObject.getString("drAccountNo");
							
						}

						if (jsonObject.has("crAccountNo") && !jsonObject.isNull("crAccountNo")) {
							creditAcNo = jsonObject.getString("crAccountNo");
							
						}

						if (jsonObject.has("amount") && !jsonObject.isNull("amount")) {
							transactionAmount = jsonObject.getString("amount");
							
							
						}

						if (jsonObject.has("bankShortName") && !jsonObject.isNull("bankShortName")) {
							bankName = jsonObject.getString("bankShortName");
						}
						if (jsonObject.has("date") && !jsonObject.isNull("date")) {
							transactionDate = jsonObject.getString("date");
						}
						
						System.out.println("transactionID = " + transactionID);
						System.out.println("TransactionAmount => " + transactionAmount);
						System.out.println("");
						NPSBEremitTransactionStatusUpdateBO oNPSBOutgoingReversalReverseListBO = new NPSBEremitTransactionStatusUpdateBO();
						oNPSBOutgoingReversalReverseListBO.setSerialNo(String.valueOf(serialNo));
						oNPSBOutgoingReversalReverseListBO.setTransactionID(transactionID);
						oNPSBOutgoingReversalReverseListBO.setDebitAcNo(debitAcNo);
						oNPSBOutgoingReversalReverseListBO.setCreditAcNo(creditAcNo);
						oNPSBOutgoingReversalReverseListBO.setTransactionAmount(transactionAmount);
						oNPSBOutgoingReversalReverseListBO.setBankName(bankName);
						oNPSBOutgoingReversalReverseListBO.setTransactionDate(transactionDate);
						aTmpList.add(oNPSBOutgoingReversalReverseListBO);
										
						
					}
					oNPSBEremitTransactionStatusUpdateBO.setReversalList(aTmpList);
								
				}
				
				if(apiDataObj == null) {
					boolean isExecute = false;
										
					if (obj.has("isExecute") && !obj.isNull("isExecute")) {
						isExecute = obj.getBoolean("isExecute");
					}
					
					if (obj.has("message") && !obj.isNull("message")) {
						message = obj.getString("message");
					}
					
					System.out.println("apiDataObj Dao => " + isExecute);
					System.out.println("apiDataObj Dao=> " + message);
					oNPSBEremitTransactionStatusUpdateBO.setErrorCode("1");
					oNPSBEremitTransactionStatusUpdateBO.setErrorMessage(message);;
					return oNPSBEremitTransactionStatusUpdateBO;
					
					
				}
				

			}else {
				oNPSBEremitTransactionStatusUpdateBO.setErrorCode("1");
				oNPSBEremitTransactionStatusUpdateBO.setErrorMessage("eRemit API does not response " + status);
			} 

		} catch (Exception e) {
			e.printStackTrace();
			oNPSBEremitTransactionStatusUpdateBO.setErrorCode("1");
			oNPSBEremitTransactionStatusUpdateBO
					.setErrorMessage("Server not Found.. Please check Internet Connection...");
		}

		return oNPSBEremitTransactionStatusUpdateBO;
		
	}
	
	
public NPSBEremitTransactionStatusUpdateBO updateNPSBeRemitAPI(NPSBEremitTransactionStatusUpdateBO model) {
		
		
		NPSBEremitTransactionStatusUpdateBO oNPSBEremitTransactionStatusUpdateBO = new NPSBEremitTransactionStatusUpdateBO();
		
		
		String responseString = "";
		String errorCode = "";
		String errorMessage = "";
		
		

		try {
			//System.out.println("updateNPSBeRemitAPI key(DAO1) ==>>> " + model.getKeyId());
			JSONObject json = new JSONObject();
			json.put("transactionID", model.getTransactionID());
			json.put("status", model.getUserStatus());
			
			System.out.println("Status(DAO) ==>>> " + model.getUserStatus());

			String jsonString = json.toString();
			System.out.println("jsonString = " + jsonString);

			String url = "http://192.168.155.16:83/api/NPSB/updateNPSBTranactionStatus";
			System.out.println("url = " + url);
			
			
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpPut httppost = new HttpPut(url);
			JSONObject jsonObject = new JSONObject(jsonString);

			StringEntity enttity = new StringEntity(String.valueOf(jsonObject));
			httppost.addHeader("Authorization", "Bearer " + model.getKeyId());
			httppost.addHeader("content-type", "application/json");
			httppost.setEntity(enttity);
			
			
			CloseableHttpResponse httpResponse = httpClient.execute(httppost);
			int status = httpResponse.getStatusLine().getStatusCode();
			System.out.println("httpResponse => " + status);
			

						
			
			if (status == 200) {
				System.out.println("status = " + status);
				responseString = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
				System.out.println("response = " + responseString);

				JSONObject obj = new JSONObject(responseString);
				System.out.println("obj = " + obj);
				
				String message = "";

				if (obj.has("message") && !obj.isNull("message")) {
					message = obj.getString("message");
                    model.setMessage(message);
				}
				System.out.println("message = " + message);
				
				if(message != "") {
					//model.setMessage(message);
					model.setErrorCode("0");
					model.setErrorMessage(message);
					return model;
				}else {
					model.setErrorCode("1");
					model.setErrorMessage("Message is Empty" );
					return model;
				}
							

			} else {
				model.setErrorCode("1");
				model.setErrorMessage("NPSB eRemit Update API does not response " + status);
			}

		} catch (Exception var17) {
			model.setErrorCode("1");
			model.setErrorMessage("Server not Found.. Please check Internet Connection...");
		}
		return oNPSBEremitTransactionStatusUpdateBO;
	}

	

}
