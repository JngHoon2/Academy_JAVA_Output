package com.magicoh.springmvc.service.sales;

import java.util.List;
import com.magicoh.springmvc.dto.InvoiceCommonDto;
import com.magicoh.springmvc.dto.InvoiceDetail;
import com.magicoh.springmvc.dto.InvoiceHeader;

public interface IInvoiceService
{
	public List<InvoiceCommonDto> getInvoiceList();
	public List<InvoiceCommonDto> getInvoiceListByCon(InvoiceCommonDto invoiceCommonResult);
	public List<InvoiceCommonDto> getInvoiceDetail(int invoice_id);
	public InvoiceCommonDto getInvoiceHeader(int invoice_no);
	public Boolean insertInvoice(InvoiceHeader invoiceHeader) throws Exception;
	public void insertInvoiceDetail(InvoiceDetail invoiceDetail);
	//public int getMaxInvoiceId();
	public InvoiceHeader getInvoiceHeaderForUpdate(int invoice_id);
	public boolean updateInvoiceHeader(InvoiceHeader invoiceHeader);
}
