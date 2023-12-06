package br.org.sesisp.view;
 
import br.org.sesisp.dao.CrudDAO;
import br.org.sesisp.model.Aluno;
import java.util.Scanner;
import javax.swing.JOptionPane;
 
public class ProjetoJava {
 
    public static void main(String[] args) {
        // Instanciar um objeto da classe CrudDAO
        CrudDAO inserirAluno = new CrudDAO();
        // Instanciar um objeto aluno
        Aluno aluno1 = new Aluno();
        Scanner entrada = new Scanner(System.in);
 
        JOptionPane.showMessageDialog(null, "Bem Vindo(a) ao nosso BD!");
 
        int opcaoDados;
        do {
            String opcao = JOptionPane.showInputDialog("O que você quer fazer?\n1 - Adicionar Dados\n2 - Atualizar Dados\n3 - Excluir Dados\n4 - Concluir\n0 - Encerrar");
            opcaoDados = Integer.parseInt(opcao);
 
            switch (opcaoDados) {
                case 1:
                    aluno1.setNome(JOptionPane.showInputDialog("Informe o Nome do Aluno: "));
                    aluno1.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Informe a idade do Aluno: ")));
                    inserirAluno.create(aluno1);
                    JOptionPane.showMessageDialog(null, "Aluno Adicionado!");
                    break;
                case 2:
                    // Atualizar Valores
                    JOptionPane.showMessageDialog(null, "Lista de Alunos disponíveis para atualização: ");
                    for (Aluno vassoura : inserirAluno.read()) {
                        JOptionPane.showMessageDialog(null, "Dados do aluno:\n" + "RA - " + vassoura.getRa() + "\nNome - " + vassoura.getNome() + "\nIdade - " + vassoura.getIdade());
                    }
                    int ra = Integer.parseInt(JOptionPane.showInputDialog("Informe o RA do Aluno que deseja atualizar: "));
                    aluno1.setRa(ra);
                    aluno1.setNome(JOptionPane.showInputDialog("Informe o novo nome: "));
                    aluno1.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Informe a nova idade: ")));
 
                    inserirAluno.update(aluno1);
                    JOptionPane.showMessageDialog(null, "Aluno atualizado!\nNome: " + aluno1.getNome() + "\nIdade: " + aluno1.getIdade());
                    break;
                case 3:
                    // Excluir dados
                    JOptionPane.showMessageDialog(null, "Lista de Alunos disponíveis para exclusão: ");
                    for (Aluno vassoura : inserirAluno.read()) {
                        JOptionPane.showMessageDialog(null, "Dados do aluno:\n" + "RA - " + vassoura.getRa() + "\nNome - " + vassoura.getNome() + "\nIdade - " + vassoura.getIdade());
                    }
                    int raExcluir = Integer.parseInt(JOptionPane.showInputDialog("Insira o RA do Aluno que deseja excluir: "));
                    CrudDAO remover_aluno = new CrudDAO();
                    remover_aluno.delete(raExcluir);
                    break;
                case 4:
                    // Ler tabela alunos do BD
                    JOptionPane.showMessageDialog(null, "Lista de Alunos:");
                    for (Aluno vassoura : inserirAluno.read()) {
                        JOptionPane.showMessageDialog(null, "Dados do aluno:\n" + "RA - " + vassoura.getRa() + "\nNome - " + vassoura.getNome() + "\nIdade - " + vassoura.getIdade());
                    }
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "O programa encerrou!");
                    break;
            }
        } while (opcaoDados != 0);
    }
}