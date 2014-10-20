package com.shanda.linglong.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shanda.linglong.model.Exam;
import com.shanda.linglong.model.Exam_tem;
import com.shanda.linglong.service.ExamService;
import com.shanda.linglong.vo.Exam_produceLv3Vo;

@Scope("prototype")
public class Exam_produceLv3Action extends ActionSupport implements
		ServletRequestAware, ModelDriven<Exam_produceLv3Vo> {

	private HttpServletRequest request;

	private HttpSession session;

	private ExamService examService;

	private Exam_produceLv3Vo exam_produceLv3Vo = new Exam_produceLv3Vo();

	public ExamService getExamService() {
		return examService;
	}

	@Resource(name = "examService")
	public void setExamService(ExamService examService) {
		this.examService = examService;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session = request.getSession();
	}

	@Override
	public Exam_produceLv3Vo getModel() {
		return exam_produceLv3Vo;
	}

	public String execute() {
		try{
			long[] e_type = (long[]) ConvertUtils.convert(
					exam_produceLv3Vo.getE_kno_id(), long.class);
			float[] e_diff = (float[]) ConvertUtils.convert(
					exam_produceLv3Vo.getE_diff(), float.class);
			List<Exam> examList = examService.getExamsByAuto(e_type,
					exam_produceLv3Vo.getE_type(),
					Long.valueOf(exam_produceLv3Vo.getE_score()), e_diff,
					Integer.valueOf(exam_produceLv3Vo.getE_length()));
			for(Exam exam : examList){
				Exam_tem exam_tem = new Exam_tem();
				exam_tem.setTp_id((Long) session.getAttribute("tp_id"));
				exam_tem.setE_id(exam.getE_id());
				examService.saveExam_tem(exam_tem);
			}
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}

}
