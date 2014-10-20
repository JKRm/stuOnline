/**
 * 试题库题目操作
 */

package com.shanda.linglong.service;

import java.util.List;

import com.shanda.linglong.model.Answer;
import com.shanda.linglong.model.Exam;
import com.shanda.linglong.model.Exam_paper;
import com.shanda.linglong.model.Exam_tem;
import com.shanda.linglong.model.Person_whole;
import com.shanda.linglong.model.Test_produce;

public interface ExamService {

	/**
	 * 上传试题库题目
	 * 
	 * @param Exam
	 *            exam
	 * @return boolean
	 * @author 山大威海hty
	 */
	public boolean add(Exam exam);

	/**
	 * 删除已上传的试题库题目
	 * 
	 * @param long e_id
	 * @return boolean
	 * @author 山大威海hty
	 */
	public boolean delete(long e_id);

	/**
	 * 更新已上传的试题库题目
	 * 
	 * @param Exam
	 *            exam
	 * @return boolean
	 * @author 山大威海hty
	 */
	public boolean update(Exam exam);

	/**
	 * 列出已上传的试题库题目列表
	 * 
	 * @param
	 * @return List<Exam>
	 * @author 山大威海hty
	 */
	public List<Exam> getExamList();

	/**
	 * 显示已上传的试题库的单道题目
	 * 
	 * @param long e_id
	 * @return Exam
	 * @author 山大威海hty
	 */
	public Exam getExamByE_id(long e_id);

	/**
	 * 自动生成某类题目
	 * 
	 * @param e_kno_id
	 * @param e_type
	 * @param e_score
	 * @param e_diff
	 * @param length
	 * @return List<Exam>
	 * @author 山大威海hty
	 */
	public List<Exam> getExamsByAuto(long[] e_kno_id, String e_type,
			long e_score, float[] e_diff, int length);

	/**
	 * 测试生成表存储
	 * 
	 * @param c_id
	 * @param tp_title
	 * @return boolean
	 * @author 山大威海hty
	 */
	public boolean saveTest_produce(long c_id, String tp_title);

	/**
	 * 试题暂存表存储
	 * 
	 * @param e_id
	 * @param e_title
	 * @return boolean
	 * @author 山大威海hty
	 */
	public boolean saveExam_tem(Exam_tem exam_tem);

	/**
	 * 存储客观题答案并记录分数
	 * @param person_id
	 * @param e_title
	 * @param title_id
	 * @param a_answer
	 * @return
	 * @author 山大威海hty
	 */
	public boolean saveObjectiveAnswer(String person_id, long e_title, long title_id,
			String a_answer);
	
	/**
	 * 存储主观题答案并记录分数
	 * @param person_id
	 * @param e_title
	 * @param title_id
	 * @param a_answer
	 * @return
	 * @author 山大威海hty
	 */
	public boolean saveSubjectiveAnswer(String person_id, long e_title, long title_id,
			String a_answer);

	/**
	 * 试题难度更新
	 * @param e_id
	 * @return boolean
	 * @author 山大威海hty
	 */
	public boolean updateDiff(long e_id);
	
	/**
	 * 选择试卷对应的答题人员
	 * @param person_id
	 * @param tp_id
	 * @return boolean
	 * @author 山大威海hty
	 */
	public boolean saveExam_paper(String person_id,long tp_id);
	
	/**
	 * 删除不合法的试卷答题人
	 * @param ep_id
	 * @return boolean
	 * @author 山大威海hty
	 */
	public boolean deleteExam_paper(long ep_id);
	
	/**
	 * 确定试卷答题人后的相关操作
	 * @param exam_paper
	 * @return boolean
	 * @author 山大威海hty
	 */
	public boolean updateExam_paper(Exam_paper exam_paper);
	
	/**
	 * 寻找某人的所有考试
	 * @param person_id
	 * @return List<Exam_paper>
	 * @author 山大威海hty
	 */
	public List<Exam_paper> getExam_paperByPerson_id(String person_id);
	
	/**
	 * 某个考试的所有人员
	 * @param tp_id
	 * @return List<Exam_paper>
	 * @author 山大威海hty
	 */
	public List<Exam_paper> getExam_paperByTp_id(long tp_id);

	/**
	 * 获得某次考试的平均分数
	 * @param tp_id
	 * @return float
	 * @author 山大威海hty
	 */
	public float getExam_paperAvg(long tp_id);
	
	/**
	 * 添加学员培训总体情况
	 * @param person_whole
	 * @return
	 * @author 山大威海hty
	 */
	public boolean addPerson_whole(Person_whole person_whole);
	
	/**
	 * 删除学员培训总体情况
	 * @param pw_id
	 * @return
	 * @author 山大威海hty
	 */
	public boolean deletePerson_whole(long pw_id);
	
	/**
	 * 更新学员培训总体情况
	 * @param person_whole
	 * @return
	 * @author 山大威海hty
	 */
	public boolean updatePerson_whole(Person_whole person_whole);
	
	/**
	 * 通过学员编号和培训编号，获取某个学员的某次培训的总体情况
	 * @param person_id
	 * @param train_id
	 * @return
	 * @author 山大威海hty
	 */
	public Person_whole getPerson_whole(long person_id, long train_id);
	
	/**
	 * 通过学员编号，获取某个学员的所有培训的总体情况
	 * @param person_id
	 * @return
	 * @author 山大威海hty
	 */
	public List<Person_whole> getPerson_wholesByPerson_id(long person_id);
	
	/**
	 * 测试生成表添加操作
	 * @param test_produce
	 * @return boolean
	 * @author 山大威海hty
	 */
	public boolean addTest_produce(Test_produce test_produce);
	
	/**
	 * 测试生成表添加操作
	 * @param tp_id
	 * @return boolean
	 * @author 山大威海hty
	 */
	public boolean deleteTest_produce(long tp_id);
	
	/**
	 * 测试生成表添加操作
	 * @param test_produce
	 * @return boolean
	 * @author 山大威海hty
	 */
	public boolean updateTest_produce(Test_produce test_produce);
	
	/**
	 * 测试生成表添加操作
	 * @param tp_id
	 * @return Test_produce
	 * @author 山大威海hty
	 */
	public Test_produce getTest_produce(long tp_id);
	
	public List<Test_produce> getTest_produceList();
	
	public List<Exam_tem> getExam_temList(long tp_id);
	
	public Exam_tem getExam_tem(long tp_id, long e_title);
	
	public Exam_paper getExam_paper(String person_id,long tp_id);
	
	public List<Exam> getExamByC_id(long e_kno_id);
	
	public List<Answer> getAnswerList(String person_id,long tp_id);
	
	public Exam_tem getExam_temBy(long tp_id, long e_id);
	
	public List<Answer> getAnswerListBy(long title_id,long tp_id);
	
	public Long getMax(long tp_id);
	
	public void updateAnswer(Answer answer);
}
