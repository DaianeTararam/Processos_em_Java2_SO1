//@author Daiane Tararam

package view;

import controller.KillController;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		KillController controller = new KillController();

		int opcao = 0;
		while (opcao != 9) {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(
					"Escolha uma opção: \n1 - Listar Processos\n2 - Matar processo por PID\n3 - Matar Processo por nome\n9 - SAIR"));
			switch (opcao) {
			case 1:
				controller.listaProcessos();
				break;
			case 2:
				int pid = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do pid"));
				controller.mataPid(pid);
				break;
			case 3:
				String pidNome = JOptionPane.showInputDialog("Digite o nome do processo: ");
				controller.mataNome(pidNome);
				break;
			case 9: 
				JOptionPane.showMessageDialog(null, "Operação finalizada!");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção Inválida.");
				break;
			}
		}

	}

}
