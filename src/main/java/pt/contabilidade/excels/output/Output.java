package pt.contabilidade.excels.output;

import org.apache.poi.ss.usermodel.Row;

public class Output {

	private Integer Grouping_Number;
	private String Document_Date;
	private String Reference;
	private String GL_Account;
	private String Vendor_Number;
	private String Special_GL_Indicator;
	private String Debit_Amount;
	private String Credit_Amount;
	private String Payment_Terms;
	private String Baseline_Date;
	private String Payment_Method;
	private String Tax_Code;
	private String Trading_Partner;
	private String Cost_Center;
	private String WBS_Element;
	private String Work_report;
	private String Purchase_Order;
	private String Purchase_Order_Item;
	private String Profit_Center;
	private String Line_Item_Text;
	private String Development_Code;
	private String Sales_Order_No;
	private String Sales_Order_Item;
	private String Network_No;
	private String Network_Activity_No;
	private String Customer_Number;
	private String Allocation;

	public Integer getGrouping_Number() {
		return Grouping_Number;
	}

	public void setGrouping_Number(Integer grouping_Number) {
		Grouping_Number = grouping_Number;
	}

	public String getDocument_Date() {
		return Document_Date;
	}

	public void setDocument_Date(String document_Date) {
		Document_Date = document_Date;
	}

	public String getReference() {
		return Reference;
	}

	public void setReference(String reference) {
		Reference = reference;
	}

	public String getGL_Account() {
		return GL_Account;
	}

	public void setGL_Account(String gL_Account) {
		GL_Account = gL_Account;
	}

	public String getVendor_Number() {
		return Vendor_Number;
	}

	public void setVendor_Number(String vendor_Number) {
		Vendor_Number = vendor_Number;
	}

	public String getSpecial_GL_Indicator() {
		return Special_GL_Indicator;
	}

	public void setSpecial_GL_Indicator(String special_GL_Indicator) {
		Special_GL_Indicator = special_GL_Indicator;
	}

	public String getDebit_Amount() {
		return Debit_Amount;
	}

	public void setDebit_Amount(String debit_Amount) {
		Debit_Amount = debit_Amount;
	}

	public String getCredit_Amount() {
		return Credit_Amount;
	}

	public void setCredit_Amount(String credit_Amount) {
		Credit_Amount = credit_Amount;
	}

	public String getPayment_Terms() {
		return Payment_Terms;
	}

	public void setPayment_Terms(String payment_Terms) {
		Payment_Terms = payment_Terms;
	}

	public String getBaseline_Date() {
		return Baseline_Date;
	}

	public void setBaseline_Date(String baseline_Date) {
		Baseline_Date = baseline_Date;
	}

	public String getPayment_Method() {
		return Payment_Method;
	}

	public void setPayment_Method(String payment_Method) {
		Payment_Method = payment_Method;
	}

	public String getTax_Code() {
		return Tax_Code;
	}

	public void setTax_Code(String tax_Code) {
		Tax_Code = tax_Code;
	}

	public String getTrading_Partner() {
		return Trading_Partner;
	}

	public void setTrading_Partner(String trading_Partner) {
		Trading_Partner = trading_Partner;
	}

	public String getCost_Center() {
		return Cost_Center;
	}

	public void setCost_Center(String cost_Center) {
		Cost_Center = cost_Center;
	}

	public String getWBS_Element() {
		return WBS_Element;
	}

	public void setWBS_Element(String wBS_Element) {
		WBS_Element = wBS_Element;
	}

	public String getWork_report() {
		return Work_report;
	}

	public void setWork_report(String work_report) {
		Work_report = work_report;
	}

	public String getPurchase_Order() {
		return Purchase_Order;
	}

	public void setPurchase_Order(String purchase_Order) {
		Purchase_Order = purchase_Order;
	}

	public String getPurchase_Order_Item() {
		return Purchase_Order_Item;
	}

	public void setPurchase_Order_Item(String purchase_Order_Item) {
		Purchase_Order_Item = purchase_Order_Item;
	}

	public String getProfit_Center() {
		return Profit_Center;
	}

	public void setProfit_Center(String profit_Center) {
		Profit_Center = profit_Center;
	}

	public String getLine_Item_Text() {
		return Line_Item_Text;
	}

	public void setLine_Item_Text(String line_Item_Text) {
		Line_Item_Text = line_Item_Text;
	}

	public String getDevelopment_Code() {
		return Development_Code;
	}

	public void setDevelopment_Code(String development_Code) {
		Development_Code = development_Code;
	}

	public String getSales_Order_No() {
		return Sales_Order_No;
	}

	public void setSales_Order_No(String sales_Order_No) {
		Sales_Order_No = sales_Order_No;
	}

	public String getSales_Order_Item() {
		return Sales_Order_Item;
	}

	public void setSales_Order_Item(String sales_Order_Item) {
		Sales_Order_Item = sales_Order_Item;
	}

	public String getNetwork_No() {
		return Network_No;
	}

	public void setNetwork_No(String network_No) {
		Network_No = network_No;
	}

	public String getNetwork_Activity_No() {
		return Network_Activity_No;
	}

	public void setNetwork_Activity_No(String network_Activity_No) {
		Network_Activity_No = network_Activity_No;
	}

	public String getCustomer_Number() {
		return Customer_Number;
	}

	public void setCustomer_Number(String customer_Number) {
		Customer_Number = customer_Number;
	}

	public String getAllocation() {
		return Allocation;
	}

	public void setAllocation(String allocation) {
		Allocation = allocation;
	}

	public void populateRow(Row row) {
		int pos = 0;

		row.createCell(pos++).setCellValue(this.Grouping_Number);
		row.createCell(pos++).setCellValue(this.Document_Date);
		row.createCell(pos++).setCellValue(this.Reference);
		row.createCell(pos++).setCellValue(this.GL_Account);
		row.createCell(pos++).setCellValue(this.Vendor_Number);
		row.createCell(pos++).setCellValue(this.Special_GL_Indicator);
		row.createCell(pos++).setCellValue(this.Debit_Amount);
		row.createCell(pos++).setCellValue(this.Credit_Amount);
		row.createCell(pos++).setCellValue(this.Payment_Terms);
		row.createCell(pos++).setCellValue(this.Baseline_Date);
		row.createCell(pos++).setCellValue(this.Payment_Method);
		row.createCell(pos++).setCellValue(this.Tax_Code);
		row.createCell(pos++).setCellValue(this.Trading_Partner);
		row.createCell(pos++).setCellValue(this.Cost_Center);
		row.createCell(pos++).setCellValue(this.WBS_Element);
		row.createCell(pos++).setCellValue(this.Work_report);
		row.createCell(pos++).setCellValue(this.Purchase_Order);
		row.createCell(pos++).setCellValue(this.Purchase_Order_Item);
		row.createCell(pos++).setCellValue(this.Profit_Center);
		row.createCell(pos++).setCellValue(this.Line_Item_Text);
		row.createCell(pos++).setCellValue(this.Development_Code);
		row.createCell(pos++).setCellValue(this.Sales_Order_No);
		row.createCell(pos++).setCellValue(this.Sales_Order_Item);
		row.createCell(pos++).setCellValue(this.Network_No);
		row.createCell(pos++).setCellValue(this.Network_Activity_No);
		row.createCell(pos++).setCellValue(this.Customer_Number);
		row.createCell(pos++).setCellValue(this.Allocation);

	}

}
