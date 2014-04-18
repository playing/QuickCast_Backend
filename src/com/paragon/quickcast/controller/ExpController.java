package com.paragon.quickcast.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.paragon.quickcast.entity.Edu_Exp;
import com.paragon.quickcast.entity.Prj_Exp;
import com.paragon.quickcast.entity.Work_Exp;
import com.paragon.quickcast.serviceImpl.EduexpServiceImpl;
import com.paragon.quickcast.serviceImpl.PrjexpServiceImpl;
import com.paragon.quickcast.serviceImpl.WorkexpServiceImpl;

@Controller
@RequestMapping("/exp.do")
public class ExpController extends MultiActionController{
	
	@Resource
	private WorkexpServiceImpl workexpimpl = new WorkexpServiceImpl();
	@Resource
	private EduexpServiceImpl eduexpimpl = new EduexpServiceImpl();
	@Resource
	private PrjexpServiceImpl prjexpimpl = new PrjexpServiceImpl();

	//Work_Exp
	@RequestMapping(params="method=workexp_insert")
	public @ResponseBody String workexp_insert(Work_Exp work_exp){
		 workexpimpl.insert(work_exp);
		 return "WorkInsert OK";
	}
	
	@RequestMapping(params="method=workexp_update")
	public @ResponseBody String workexp_update(Work_Exp work_exp){
		 workexpimpl.update(work_exp);
		 return "WorkUpdate OK";
	}
	
	@RequestMapping(params="method=queryByWorkexpId")
	public @ResponseBody String queryByWorkexpId(int exp_id){
		 Work_Exp work_exp = workexpimpl.queryByWorkexpId(exp_id);
		 System.out.println("-----------workexp_id:"+work_exp.getExp_id()+"---------");
		 System.out.println("-----------user_id:"+work_exp.getUser_id()+"---------");
	     return "queryByWorkexpId OK";
	    }
	 
	@RequestMapping(params="method=workexp_delete")
	public @ResponseBody String workexp_delete(Work_Exp work_exp){
		 workexpimpl.delete(work_exp);
	     return "workexp_delete OK";
	    }
	
	@RequestMapping(params="method=queryByWorkuserId")
	public @ResponseBody String queryByWorkuserId(int user_id){
		 List list = workexpimpl.queryByUserId(user_id);
		 for(int i = 0;i < list.size();i ++){
			 Work_Exp work_exp = (Work_Exp)list.get(i);
			 System.out.println("-----------workexp_id:"+work_exp.getExp_id()+"---------");
			 System.out.println("-----------user_id:"+work_exp.getUser_id()+"---------");
		 }
	     return "queryByWorkuserId OK";
	    }
	 
	@RequestMapping(params="method=deleteByWorkuserId")
	public @ResponseBody String deleteByWorkuserId(int user_id){
		 workexpimpl.deleteByUserId(user_id);
	     return "deleteByWorkuserId OK";
	    }
	
	@RequestMapping(params="method=deleteByWorkexpId")
	public @ResponseBody String deleteByWorkexpId(int exp_id){
		 workexpimpl.deleteByExpId(exp_id);
	     return "deleteByWorkexpId OK";
	    }
	
	//Edu_Exp
	@RequestMapping(params="method=eduexp_insert")
	public @ResponseBody String eduexp_insert(Edu_Exp edu_exp){
		eduexpimpl.insert(edu_exp);
		return "EduInsert OK";
	}
	
	@RequestMapping(params="method=eduexp_update")
	public @ResponseBody String eduexp_update(Edu_Exp edu_exp){
		eduexpimpl.update(edu_exp); 
		return "EduUpdate OK";
	}
	
	@RequestMapping(params="method=queryByEduexpId")
    public @ResponseBody String queryByEduexpId(int exp_id){
		Edu_Exp edu_exp = eduexpimpl.queryByEduexpId(exp_id);
		System.out.println("-----------eduexp_id:"+edu_exp.getExp_id()+"---------");
		System.out.println("-----------user_id:"+edu_exp.getUser_id()+"---------");
		return "queryByEduexpId OK";
    }
	
	@RequestMapping(params="method=eduexp_delete")
	public @ResponseBody String eduexp_delete(Edu_Exp edu_exp){
		eduexpimpl.delete(edu_exp);
	    return "eduexp_delete OK";
	}
	
	@RequestMapping(params="method=queryByEduuserId")
	public @ResponseBody String queryByEduuserId(int user_id){
		 List list = eduexpimpl.queryByUserId(user_id);
		 for(int i = 0;i < list.size();i ++){
			 Edu_Exp edu_exp = (Edu_Exp)list.get(i);
			 System.out.println("-----------eduexp_id:"+edu_exp.getExp_id()+"---------");
			 System.out.println("-----------user_id:"+edu_exp.getUser_id()+"---------");
		 }
	     return "queryByEduuserId OK";
	    }
	 
	@RequestMapping(params="method=deleteByEduuserId")
	public @ResponseBody String deleteByEduuserId(int user_id){
		 eduexpimpl.deleteByUserId(user_id);
	     return "deleteByEduuserId OK";
	    }
	
	@RequestMapping(params="method=deleteByEduexpId")
	public @ResponseBody String deleteByEduexpId(int exp_id){
		 eduexpimpl.deleteByExpId(exp_id);
	     return "deleteByEduexpId OK";
	    }
	
	//Prj_Exp
	@RequestMapping(params="method=prjexp_insert")
	public @ResponseBody String prjexp_insert(Prj_Exp prj_exp){
		prjexpimpl.insert(prj_exp);
		return "PrjInsert OK";
	}
	
	@RequestMapping(params="method=prjexp_update")
	public @ResponseBody String prjexp_update(Prj_Exp prj_exp){
		prjexpimpl.update(prj_exp); 
		return "PrjUpdate OK";
	}
	
	@RequestMapping(params="method=queryByPrjexpId")
    public @ResponseBody String queryByPrjexpId(int exp_id){
		Prj_Exp prj_exp = prjexpimpl.queryByPrjexpId(exp_id);
		System.out.println("-----------prjexp_id:"+prj_exp.getExp_id()+"---------");
		System.out.println("-----------user_id:"+prj_exp.getUser_id()+"---------");
		return "queryByPrjexpId OK";
    }
	
	@RequestMapping(params="method=prjexp_delete")
	public @ResponseBody String prjexp_delete(Prj_Exp prj_exp){
		prjexpimpl.delete(prj_exp);
	    return "prjexp_delete OK";
	}
	
	@RequestMapping(params="method=queryByPrjuserId")
	public @ResponseBody String queryByPrjuserId(int user_id){
		 List list = prjexpimpl.queryByUserId(user_id);
		 for(int i = 0;i < list.size();i ++){
			 Prj_Exp prj_exp = (Prj_Exp)list.get(i);
			 System.out.println("-----------eduexp_id:"+prj_exp.getExp_id()+"---------");
			 System.out.println("-----------user_id:"+prj_exp.getUser_id()+"---------");
		 }
	     return "queryByPrjuserId OK";
	    }
	 
	@RequestMapping(params="method=deleteByPrjuserId")
	public @ResponseBody String deleteByPrjuserId(int user_id){
		 prjexpimpl.deleteByUserId(user_id);
	     return "deleteByPrjuserId OK";
	    }
	
	@RequestMapping(params="method=deleteByPrjexpId")
	public @ResponseBody String deleteByPrjexpId(int exp_id){
		 prjexpimpl.deleteByExpId(exp_id);
	     return "deleteByPrjexpId OK";
	    }

	
	
	
	public WorkexpServiceImpl getWorkexpimpl() {
		return workexpimpl;
	}

	public void setWorkexpimpl(WorkexpServiceImpl workexpimpl) {
		this.workexpimpl = workexpimpl;
	}

	public EduexpServiceImpl getEduexpimpl() {
		return eduexpimpl;
	}

	public void setEduexpimpl(EduexpServiceImpl eduexpimpl) {
		this.eduexpimpl = eduexpimpl;
	}

	public PrjexpServiceImpl getPrjexpimpl() {
		return prjexpimpl;
	}

	public void setPrjexpimpl(PrjexpServiceImpl prjexpimpl) {
		this.prjexpimpl = prjexpimpl;
	}
	
	
	
}
