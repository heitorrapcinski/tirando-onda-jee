package tirando.onda.jee.exemplo.jsf.view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.faces.model.SelectItem;

public class SampleModel {
	
	private String textField;
	private Date dateField;
	private Integer choiceField = -1;
	private BigDecimal decimalField;
	
	private Collection<SelectItem> choiceFieldValues = new ArrayList<SelectItem>();
	
	public SampleModel() {
		choiceFieldValues.add(new SelectItem(-1,""));
		choiceFieldValues.add(new SelectItem(1,"value1"));
		choiceFieldValues.add(new SelectItem(2,"value2"));
		choiceFieldValues.add(new SelectItem(3,"value3"));
		choiceFieldValues.add(new SelectItem(4,"value4"));
		
		decimalField = new BigDecimal("1155.37");
		decimalField.setScale(2);
		decimalField = decimalField.add(new BigDecimal("0.5231"));
	}

	public String getTextField() {
		return textField;
	}

	public void setTextField(String textField) {
		this.textField = textField;
	}

	public Date getDateField() {
		return dateField;
	}

	public void setDateField(Date dateField) {
		this.dateField = dateField;
	}

	public Integer getChoiceField() {
		return choiceField;
	}

	public void setChoiceField(Integer choiceField) {
		this.choiceField = choiceField;
	}

	public BigDecimal getDecimalField() {
		return decimalField;
	}

	public void setDecimalField(BigDecimal decimalField) {
		this.decimalField = decimalField;
	}
	
	public Collection<SelectItem> getChoiceFieldValues() {
		return choiceFieldValues;
	}

	public void setChoiceFieldValues(Collection<SelectItem> choiceFieldValues) {
		this.choiceFieldValues = choiceFieldValues;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TextField:");
		builder.append(textField);
		builder.append(",DateField:");
		builder.append(dateField);
		builder.append(",ChoiceField:");
		builder.append(choiceField);
		builder.append(",decimalField:");
		builder.append(decimalField);

		return builder.toString();
	}

}
