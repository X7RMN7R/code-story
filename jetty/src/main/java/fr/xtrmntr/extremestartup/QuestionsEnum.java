package fr.xtrmntr.extremestartup;

public enum QuestionsEnum {
	Q1("Quelle est ton adresse email", "uv0.xtr@gmail.com"),
	Q2("Es tu heureux de participer(OUI/NON)", "OUI");
	
	private final String question;
	private final String answer;
	
	QuestionsEnum(String question, String answer) {
		this.question = question;
		this.answer = answer;
	}
	
	public String getQuestion() {
		return this.question;
	}
	
	public String getAnswer() {
		return this.answer;
	}
	
	public static QuestionsEnum fromQuestion(String question) {
		if (question != null) {
		      for (QuestionsEnum enumValue : QuestionsEnum.values()) {
		        if (question.equalsIgnoreCase(enumValue.getQuestion())) {
		          return enumValue;
		        }
		      }
		    }
		    return null;
	}
}
