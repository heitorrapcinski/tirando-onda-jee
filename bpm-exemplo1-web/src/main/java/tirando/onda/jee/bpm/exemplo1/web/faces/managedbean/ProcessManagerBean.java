package tirando.onda.jee.bpm.exemplo1.web.faces.managedbean;

import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import br.gov.serpro.bpm.context.ActivitiContext;
import br.gov.serpro.bpm.context.BPMContext;


public class ProcessManagerBean {
	
	public ProcessDefinition selectedProcessDefinition;
	                         
	private BPMContext<ProcessEngine> ctx = new ActivitiContext();
	
	public ProcessDefinition getSelectedProcessDefinition() {
		return selectedProcessDefinition;
	}

	public void setSelectedProcessDefinition(ProcessDefinition selectedProcessDefinition) {
		this.selectedProcessDefinition = selectedProcessDefinition;
	}

	public DataModel getProcessDefinition() {
		List<ProcessDefinition> list = ctx.getEngine().getRepositoryService().createProcessDefinitionQuery()
			.list();
		
		return new ListDataModel(list);
	}
	
	public DataModel getProcessInstance() {
		if (selectedProcessDefinition == null) {
			return new ListDataModel();
		}
		
		List<ProcessInstance> list = ctx.getEngine().getRuntimeService().createProcessInstanceQuery()
			.processDefinitionId(selectedProcessDefinition.getId())
			.list();
		
		return new ListDataModel(list);
	}
	
	public DataModel getTask() {
		if (selectedProcessDefinition == null) {
			return new ListDataModel();
		}

		List<Task> list = ctx.getEngine().getTaskService().createTaskQuery()
			.processDefinitionId(selectedProcessDefinition.getId())
			.list();
		
		return new ListDataModel(list);
	}
	
	public String startProcess() {
		ctx.getEngine().getRuntimeService()
			.startProcessInstanceById(selectedProcessDefinition.getId());
		
		return "process-manager";
	}
	
}
