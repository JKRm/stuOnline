package com.shanda.linglong.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shanda.linglong.model.Message_temp;
import com.shanda.linglong.model.Person_detail;
import com.shanda.linglong.model.Record;
import com.shanda.linglong.model.Record_discuss;
import com.shanda.linglong.service.Person_detailService;
import com.shanda.linglong.service.RecordService;
import com.shanda.linglong.vo.DetailVo;
import com.shanda.linglong.vo.DiscussVo;
import com.shanda.linglong.vo.MessageVo;
import com.shanda.linglong.vo.PageView;
import com.shanda.linglong.vo.PublishVo;
import com.shanda.linglong.vo.QueryResult;

public class CommunityAction extends ActionSupport implements
		ModelDriven<PublishVo>, ServletRequestAware {

	private HttpServletRequest request;

	private HttpSession session;

	private RecordService rs;

	private Person_detailService pds;

	private PublishVo pv = new PublishVo();

	private DetailVo dv;

	@Resource(name = "recordService")
	public void setRs(RecordService rs) {
		this.rs = rs;
	}

	public RecordService getRs() {
		return rs;
	}

	public Person_detailService getPds() {
		return pds;
	}

	@Resource(name = "person_detailService")
	public void setPds(Person_detailService pds) {
		this.pds = pds;
	}

	public void setDv(DetailVo dv) {
		this.dv = dv;
	}

	public DetailVo getDv() {
		return dv;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {

		this.request = request;

		this.session = request.getSession();

	}

	public String getAll() {

		int currentpage = 0;

		if (request.getParameter("currentpage") == null) {
			currentpage = 1;
		} else {
			currentpage = Integer.parseInt(request.getParameter("currentpage"));
		}

		PageView<Record> pageView = new PageView<Record>(8, currentpage);

		QueryResult<Record> queryResult = null;

		String user = session.getAttribute("myUser").toString();

		int messageCount = rs.messageListCount(user);

		// List<Record> recordList = new ArrayList<Record>();

		queryResult = rs.getRecordList(pageView.getFirstResult(),
				pageView.getMaxresult());

		List<DetailVo> voList = new ArrayList<DetailVo>();

		String nickname = null;

		for (int i = 0; i < queryResult.getResultlist().size(); i++) {

			DetailVo detail = new DetailVo();

			String person_id = queryResult.getResultlist().get(i)
					.getPerson_id();

			nickname = pds.getNickname(person_id);

			detail.setRecord(queryResult.getResultlist().get(i));

			detail.setNickname(nickname);

			detail.setPhoto_url(pds.getPhotourl(person_id));

			voList.add(detail);
		}

		pageView.setQueryResult(queryResult);

		request.setAttribute("pageView", pageView);

		request.setAttribute("voList", voList);

		request.setAttribute("messageCount", messageCount);

		return SUCCESS;
	}

	public String searchInfo() {
		
		int currentpage = 0;

		if (request.getParameter("currentpage") == null) {
			currentpage = 1;
		} else {
			currentpage = Integer.parseInt(request.getParameter("currentpage"));
		}
		
		PageView<Record> pageView = new PageView<Record>(5, currentpage);

		QueryResult<Record> queryResult = null;

		String person_id = null;
		
		if (request.getParameter("pid") == null) {

			person_id = session.getAttribute("pid").toString();
	
		}

		else {

			person_id = request.getParameter("pid");

			session.setAttribute("pid", person_id);


		}

		Person_detail pd = new Person_detail();

		pd = pds.getInfo(person_id);

		List<Record> rList = new ArrayList<Record>();

		queryResult = rs.getRecordListByPerson(person_id,pageView.getFirstResult(),
				pageView.getMaxresult());
		
		rList = queryResult.getResultlist();
		
		pageView.setQueryResult(queryResult);

		request.setAttribute("pageView", pageView);

		request.setAttribute("rList", rList);

		request.setAttribute("personDetail", pd);

		return SUCCESS;
	}
	
	public String publishDoc(){
		
		Record record = new Record();

		record.setPerson_id((String) session.getAttribute("myUser"));
		
		record.setR_content(pv.getContent());
		
		record.setR_title(pv.getTitle());
		
		rs.RecordAdd(record);

		return SUCCESS;
	}


	public String publish() throws Exception {

		Record record = new Record();

		record.setPerson_id((String) session.getAttribute("myUser"));

		record.setR_content(pv.getContent());

		Date date = new Date();

		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddhhmmss");

		String sd = sf.format(date);

		if (pv.getUploadFileName() != null
				&& !(pv.getUploadFileName().isEmpty())) {

			String type = pv
					.getUploadFileName()
					.substring(pv.getUploadFileName().lastIndexOf(".") + 1,
							pv.getUploadFileName().length()).toLowerCase();

			System.out.println(type);

			String saveName = sd + "." + type;

			if (pv.getUploadFileName() != null
					&& !((pv.getUploadFileName()).isEmpty())) {

				record.setR_phourl(saveName);
			}

			String savePath = System.getenv("CATALINA_HOME")
					+ "\\webapps\\studentOnline_source\\community\\image\\";
			
			System.out.println("     4324    "+savePath);

			String filePath = savePath + "\\" + saveName;

			FileOutputStream fos = new FileOutputStream(filePath);

			FileInputStream fis = new FileInputStream(pv.getUpload());

			byte[] buffer = new byte[1024];

			int len = 0;

			boolean flag = true;

			while ((len = fis.read(buffer)) > 0) {

				fos.write(buffer, 0, len);
			}

			fos.close();

		}

		rs.RecordAdd(record);

		return SUCCESS;
	}

	public String delRecord() {

		long r_id = Long.parseLong(request.getParameter("rid"));

		boolean flag = true;

		Record record = new Record();

		record = rs.getRecord(r_id);
		
		flag = rs.RecordDel(r_id);
		
		System.out.println(flag);
		
		flag = flag && rs.delDiscussByrid(r_id);
		
		System.out.println(flag);
		
		flag = flag && rs.delMessageByRid(r_id);
		
		System.out.println(flag);
		
		if (flag) {

			String path = System.getenv("CATALINA_HOME")
					+ "\\webapps\\studentOnline_source\\community\\image\\";

			File imgFile;

			imgFile = new File(path + record.getR_phourl());

			if (imgFile.exists()) {

				imgFile.delete();

			}

			request.setAttribute("message", "Î¢ÑÔÉ¾³ý³É¹¦£¡");

			return SUCCESS;

		}

		return ERROR;
	}

	public String discuss() {
		
		int currentpage = 0;

		long r_id = 0;

		String mark = null;
		
		if (request.getParameter("currentpage") == null) {
			
			currentpage = 1;
			
		} 
		else {
			
			currentpage = Integer.parseInt(request.getParameter("currentpage"));
		}

		if (request.getParameter("rid") == null) {

			r_id = Long.parseLong(session.getAttribute("rid").toString());

			mark = session.getAttribute("mark").toString();
		}

		else {

			r_id = Long.parseLong(request.getParameter("rid"));

			mark = request.getParameter("mark");

			session.setAttribute("rid", r_id);

			session.setAttribute("mark", mark);

		}
		
		PageView<Record_discuss> pageView = new PageView<Record_discuss>(7, currentpage);

		QueryResult<Record_discuss> queryResult = null;

		Record record = new Record();

		record = rs.getRecord(r_id);

		// record.setR_comment(record.getR_comment() + 1);
		//
		// rs.updateRecord(record);

		List<Record_discuss> rdList = new ArrayList<Record_discuss>();

		queryResult = rs.getDiscussListByrid(pageView.getFirstResult(),
				pageView.getMaxresult(),r_id, mark);
		
		rdList = queryResult.getResultlist();

		String nickname = null;

		List<DiscussVo> dvList = new ArrayList<DiscussVo>();

		for (int i = 0; i < rdList.size(); i++) {

			DiscussVo discuss = new DiscussVo();

			String person_id = rdList.get(i).getPerson_id();

			nickname = pds.getNickname(person_id);

			discuss.setNickname(nickname);

			discuss.setRecord_discuss(rdList.get(i));

			dvList.add(discuss);

		}
		
		pageView.setQueryResult(queryResult);
		
		session.setAttribute("recordDoc", record);

		request.setAttribute("dvList", dvList);

		request.setAttribute("rid", r_id);

		request.setAttribute("pageView", pageView);

		return SUCCESS;
	}

	public String addDis() {

		long r_id = Long.parseLong(pv.getTo());

		Record record = new Record();

		Message_temp mt = new Message_temp();

		record = rs.getRecord(r_id);

		record.setR_comment(record.getR_comment() + 1);

		boolean flag = rs.updateRecord(record);

		Record_discuss rd = new Record_discuss();

		rd.setPerson_id(session.getAttribute("myUser").toString());

		rd.setR_id(r_id);

		rd.setRd_content(pv.getContent());

		rd.setRd_iscom("true");

		flag = rs.RecordDiscussAdd(rd) && flag;

		mt.setPerson_id_recieve(record.getPerson_id());

		mt.setPerson_id_send(session.getAttribute("myUser").toString());

		mt.setR_id(r_id);

		flag = flag && rs.addMessage(mt);

		if (flag) {

			return SUCCESS;
		}

		return ERROR;
	}

	public String addRes() {

		long r_id = Long.parseLong(pv.getTo());

		Record record = new Record();

		Record resRecord = new Record();

		record = rs.getRecord(r_id);

		record.setR_resend(record.getR_resend() + 1);

		boolean flag = rs.updateRecord(record);

		Record_discuss rd = new Record_discuss();

		rd.setPerson_id(session.getAttribute("myUser").toString());

		rd.setR_id(r_id);

		String nickname = null;

		nickname = pds.getNickname(record.getPerson_id());

		String resContent = pv.getContent() + "//" + "@" + nickname + ":"
				+ record.getR_content();

		rd.setRd_content(resContent);

		rd.setRd_iscom("false");

		flag = rs.RecordDiscussAdd(rd) && flag;

		resRecord.setPerson_id(session.getAttribute("myUser").toString());

		resRecord.setR_content(resContent);

		resRecord.setR_phourl(record.getR_phourl());

		flag = flag && rs.RecordAdd(resRecord);

		if (flag) {

			return SUCCESS;
		}

		return ERROR;
	}

	public String delDiscuss() {

		long rd_id = Long.parseLong(request.getParameter("rdid"));

		Record record = new Record();

		long r_id = rs.getrid(rd_id);

		record = rs.getRecord(r_id);

		record.setR_comment(record.getR_comment() - 1);

		boolean flag = rs.updateRecord(record);

		flag = flag && rs.RecordDiscussDel(rd_id);

		if (flag) {

			return SUCCESS;
		}

		return ERROR;
	}

	public String addMessage() {

		Message_temp mt = new Message_temp();

		boolean flag = true;

		mt.setPerson_id_recieve(pv.getTo());

		mt.setPerson_id_send(session.getAttribute("myUser").toString());

		mt.setR_id(Long.parseLong(pv.getSource()));

		flag = flag && rs.addMessage(mt);

		Record_discuss rd = new Record_discuss();

		rd.setPerson_id(session.getAttribute("myUser").toString());

		rd.setR_id(Long.parseLong(pv.getSource()));

		rd.setRd_iscom("true");

		String toNick = pds.getNickname(pv.getTo());

		String content = "»Ø¸´ " + toNick + ": " + pv.getContent();

		rd.setRd_content(content);

		flag = flag && rs.RecordDiscussAdd(rd);

		if (flag) {

			return SUCCESS;
		}

		return ERROR;

	}

	public String getMessageList() {
		
		int currentpage = 0;

		if (request.getParameter("currentpage") == null) {
			currentpage = 1;
		} else {
			currentpage = Integer.parseInt(request.getParameter("currentpage"));
		}
		
		PageView<Message_temp> pageView = new PageView<Message_temp>(10, currentpage);

		QueryResult<Message_temp> queryResult = null;

		String user = session.getAttribute("myUser").toString();

		List<Message_temp> mtList = new ArrayList<Message_temp>();

		queryResult = rs.getMessageList(user,pageView.getFirstResult(),
				pageView.getMaxresult());
		
		mtList = queryResult.getResultlist();

		List<MessageVo> mvList = new ArrayList<MessageVo>();

		String nickname = null;

		for (int i = 0; i < mtList.size(); i++) {

			Record record = new Record();

			MessageVo mv = new MessageVo();

			record = rs.getRecord(mtList.get(i).getR_id());

			mv.setContent(record.getR_content());

			nickname = pds.getNickname(mtList.get(i).getPerson_id_send());

			mv.setNickname(nickname);

			mv.setPerson_id(mtList.get(i).getPerson_id_send());

			mv.setR_id(mtList.get(i).getR_id());

			mv.setMt_id(mtList.get(i).getMt_id());

			mvList.add(mv);

		}
		
		pageView.setQueryResult(queryResult);

		request.setAttribute("pageView", pageView);

		request.setAttribute("mvList", mvList);

		return SUCCESS;
	}

	public String delMessage() {
		
		System.out.println("      "+request.getParameter("mtid"));

		long mt_id = Long.parseLong(request.getParameter("mtid"));

		boolean flag = true;

		flag = rs.delMessage(mt_id);

		if (flag) {

			return SUCCESS;
		}

		return ERROR;
	}

	public String delAllMessage() {

		String user = session.getAttribute("myUser").toString();

		boolean flag = true;

		flag = rs.delMessageByRecieveId(user);

		if (flag) {

			return SUCCESS;
		}

		return ERROR;
	}

	public String personSearch() {
		
		int currentpage = 0;

		if (request.getParameter("currentpage") == null) {
			currentpage = 1;
		} else {
			currentpage = Integer.parseInt(request.getParameter("currentpage"));
		}
		
		PageView<Person_detail> pageView = new PageView<Person_detail>(10, currentpage);

		QueryResult<Person_detail> queryResult = null;

		List<Person_detail> pdList = new ArrayList<Person_detail>();
		
		String source = null;
		
		if(pv.getSource()!=null&&!(pv.getSource().isEmpty())){
			
			source = pv.getSource();
			
			session.setAttribute("pvSource", pv.getSource());
		}
		
		else{
			
			source = session.getAttribute("pvSource").toString();
		}

		queryResult = pds.getinfoBynn(source,pageView.getFirstResult(),
				pageView.getMaxresult());
		
		pdList = queryResult.getResultlist();
		
		pageView.setQueryResult(queryResult);

		request.setAttribute("pageView", pageView);

		request.setAttribute("pdList", pdList);

		return SUCCESS;
	}

	public String personInfo() {

		Person_detail pd = new Person_detail();

		pd = pds.getInfo(session.getAttribute("myUser").toString());

		request.setAttribute("pd", pd);

		return SUCCESS;
	}

	public String saveInfo() throws Exception {

		Person_detail pd = new Person_detail();

		pd = pds.getInfo(session.getAttribute("myUser").toString());

		pd.setPd_email(dv.getEmail());

		pd.setPd_nickname(dv.getNickname());

		if (dv.getUpload() != null) {

			Date date = new Date();

			SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddhhmmss");

			String sd = sf.format(date);

			if (dv.getUploadFileName() != null
					&& !(dv.getUploadFileName().isEmpty())) {

				String type = dv
						.getUploadFileName()
						.substring(dv.getUploadFileName().lastIndexOf(".") + 1,
								dv.getUploadFileName().length()).toLowerCase();

				String saveName = sd + "." + type;

				if (dv.getUploadFileName() != null
						&& !((dv.getUploadFileName()).isEmpty())) {

					pd.setPd_photo(saveName);
				}

				String savePath = System.getenv("CATALINA_HOME")
						+ "\\webapps\\studentOnline_source\\community\\portrait\\";
				
				System.out.println(savePath);

				String filePath = savePath + "\\" + saveName;

				FileOutputStream fos = new FileOutputStream(filePath);

				FileInputStream fis = new FileInputStream(dv.getUpload());

				byte[] buffer = new byte[1024];

				int len = 0;

				boolean flag = true;

				while ((len = fis.read(buffer)) > 0) {

					fos.write(buffer, 0, len);
				}

				fos.close();

			}

		}

		if (pds.updateDetail(pd)) {

			return SUCCESS;
		}

		return ERROR;
	}

	@Override
	public PublishVo getModel() {
		// TODO Auto-generated method stub
		return pv;
	}

}
