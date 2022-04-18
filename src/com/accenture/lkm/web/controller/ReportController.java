package com.accenture.lkm.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.business.bean.CustomerBean;
import com.accenture.lkm.business.bean.DateRangeBean;
import com.accenture.lkm.service.CustomerService;
import com.accenture.lkm.service.CustomerServiceImpl;

@Controller
public class ReportController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/loadReportPage", method = RequestMethod.GET)
	public ModelAndView loadReportForm() throws Exception {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("CustomerDetails");
		modelAndView.addObject("dateBean", new DateRangeBean());
		return modelAndView;
	}

	@RequestMapping(value = "/getCustomerRec", method = RequestMethod.GET)
	public ModelAndView getCustomerRecords(@ModelAttribute("dateBean") DateRangeBean dateRangeBean) throws Exception {

		List<CustomerBean> customerBeans = customerService.getCustomerDetails(dateRangeBean.getFromDate(),
				dateRangeBean.getToDate());

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("CustomerDetails");
		modelAndView.addObject("custList", customerBeans);
		return modelAndView;
	}

	/*
	 * @ModelAttribute("CTList") public Map<String, String> setCustomerType() throws
	 * Exception{ return customerService.setCustomerType(); }
	 */

	// Error Handler:
	@ExceptionHandler(value = Exception.class)
	public ModelAndView handleAllExceptions(Exception exception) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("GeneralizedExceptionHandlerPage");
		modelAndView.addObject("message", exception.getMessage());
		modelAndView.addObject("exception", exception);
		return modelAndView;
	}

}
