package objetos;

import java.util.List;

public class Registro {
	
	private List<Disciplina> registro_disciplinas_Professor;
	private List<Disciplina> registro_disciplinas_Alunos;
	private List<Aluno> registro_alunos;
	private List<Professor> registro_professores;
	
	public void registrarProfessor(Professor prof, Disciplina disciplina) throws Exception{
		if(registro_disciplinas_Professor.contains(disciplina)){
			throw new Exception("Não é possível registrar, pois a disciplina informada já tem professor cadastrado.");
		}else{
			registro_professores.add(prof);
			registro_disciplinas_Professor.add(registro_professores.size()-1, disciplina);
		}
		
	}
	
	public String disciplinasProfessor(String cpf){
		StringBuilder info = new StringBuilder();

		info.append("Disciplinas do Professor: \n");
		for(int i = 0; i < registro_professores.size() ; i++){
			if(registro_professores.get(i).getCpf() == cpf){
				info.append(registro_disciplinas_Professor.get(i).getNome());
			}
		}
		
		return info.toString();
	}
	
	public String horarioProfessor(String cpf){
		StringBuilder info = new StringBuilder();
		
		info.append("Horário do Professor: \n");
		for(int i = 0; i < registro_professores.size() ; i++){
			if(registro_professores.get(i).getCpf() == cpf){
				info.append(registro_disciplinas_Alunos.get(i).getHorario());
			}
		}
		
		return info.toString();
	}
	
	public void registrarAluno(Aluno aluno, Disciplina disciplina){
		registro_alunos.add(aluno);
		registro_disciplinas_Alunos.add(registro_alunos.size()-1, disciplina);
	}
	
	public String disciplinasAluno(int matricula){
		StringBuilder info = new StringBuilder();
		
		info.append("Disciplinas do aluno: \n");
		for(int i = 0; i < registro_alunos.size() ; i++){
			if(registro_alunos.get(i).getMatricula() == matricula){
				info.append(registro_disciplinas_Alunos.get(i).getNome());
			}
		}
		
		return info.toString();
	}
	
	public String horarioAluno(int matricula){
		StringBuilder info = new StringBuilder();
		
		info.append("Horário do aluno: \n");
		for(int i = 0; i < registro_alunos.size() ; i++){
			if(registro_alunos.get(i).getMatricula() == matricula){
				info.append(registro_disciplinas_Alunos.get(i).getHorario());
			}
		}
		
		return info.toString();
	}
	
	public int numAlunosDisciplina(int id) throws Exception{
		int tot = 0;
		for(int i = 0; i < registro_disciplinas_Alunos.size(); i++){
			if(registro_disciplinas_Alunos.get(i).getId() == id){
				tot++;
			}
		}
		
		return tot; 
	}
	
	
}
