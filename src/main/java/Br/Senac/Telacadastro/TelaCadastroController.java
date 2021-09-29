package Br.Senac.Telacadastro;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

public class TelaCadastroController implements Initializable {

    @FXML
    private TextField txtTelFixo;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtCel;
    @FXML
    private CheckBox cbTelFixo;
    @FXML
    private CheckBox cbCel;
    @FXML
    private CheckBox cbEmail;
    @FXML
    private RadioButton radioSim;
    @FXML
    private ToggleGroup permiteContato;
    @FXML
    private RadioButton radioNao;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtSobrenome;
    @FXML
    private TextField txtRg;
    @FXML
    private TextField txtCpf;
    @FXML
    private DatePicker dpNascimento;
    @FXML
    private ComboBox comboGenero;
    @FXML
    private TextField outrogenero;
    
    private String nome = "";
    private String sobrenome = "";
    private String telfixo = "";
    private String email = "";
    private String cel = "";
    private String rg = "";
    private String cpf = "";
    private LocalDate nascimento;
    private int genero = -1;
    private Toggle contato = null;
    private boolean contatocel = false;
    private boolean contatotelfixo = false;
    private boolean contatoemail = false;
    private String generoEscolha = "";
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        comboGenero.getItems().add("Masculino");
        comboGenero.getItems().add("Feminino");
        comboGenero.getItems().add("Não-binario");
        comboGenero.getItems().add("Prefiro não informar");
        comboGenero.getItems().add("Outro");
        
    }    

    @FXML
    private void sair(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void limpar(ActionEvent event) {
        txtNome.clear();
        txtSobrenome.clear();
        txtCpf.clear();
        txtRg.clear();
        txtCel.clear();
        txtEmail.clear();
        txtTelFixo.clear();
        dpNascimento.setValue(null);
        comboGenero.getSelectionModel().clearSelection();
        permiteContato.selectToggle(null);
        cbCel.setSelected(false);
        cbTelFixo.setSelected(false);
        cbEmail.setSelected(false);
        outrogenero.clear();
    }
    
    @FXML
    private void carregar(ActionEvent event) {
        if(!nome.equals("")){
            txtNome.setText(nome);
        } 
        if(!sobrenome.equals("")){
            txtSobrenome.setText(sobrenome);
        } 
        if(!cpf.equals("")){
            txtCpf.setText(cpf);
        } 
        if(!rg.equals("")){
            txtRg.setText(rg);
        } 
        if(!telfixo.equals("")){
            txtTelFixo.setText(telfixo);
        } 
        if(!cel.equals("")){
            txtCel.setText(cel);
        } 
        if(!email.equals("")){
            txtEmail.setText(email);
        } 
        if(nascimento != null){
            dpNascimento.setValue(nascimento);
        }
        if (genero != -1) {
            comboGenero.getSelectionModel().select(genero);
        }
        if (contato != null) {
            permiteContato.selectToggle(contato);
        }
        if (contatocel == true) {
            cbCel.setSelected(contatocel);
        }
        if (contatoemail == true) {
            cbEmail.setSelected(contatoemail);
        }
        if (contatotelfixo == true) {
            cbTelFixo.setSelected(contatotelfixo);
        }
        if(!generoEscolha.equals("")){
            outrogenero.setText(generoEscolha);
        }
    }
    @FXML
    private void salvar(ActionEvent event) {
        nome = txtNome.getText();
        sobrenome = txtSobrenome.getText();
        cpf = txtCpf.getText();
        telfixo = txtTelFixo.getText();
        rg = txtRg.getText();
        email = txtEmail.getText();
        cel = txtCel.getText();
        generoEscolha = outrogenero.getText();
        
        nascimento = dpNascimento.getValue();
        genero = comboGenero.getSelectionModel().getSelectedIndex();
        contato = permiteContato.getSelectedToggle();
        contatocel = cbCel.isSelected();
        contatoemail = cbEmail.isSelected();
        contatotelfixo = cbTelFixo.isSelected();
        
               
    }

    @FXML
    private void finalizarCadastro(ActionEvent event) {
        
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
        
        if (txtNome.getText().equals("") || txtSobrenome.getText().equals("") 
                || txtCpf.getText().equals("") || txtRg.getText().equals("")
                || txtCel.getText().equals("") || txtEmail.getText().equals("") 
                || dpNascimento.getValue() == null || comboGenero.getValue() == null
                || permiteContato.getSelectedToggle() == null ) {
          
            alert.setTitle("Erro na validação do cadastro");
            alert.setHeaderText("Campos obrigatórios");
            alert.setContentText("Falta preencher campos obrigatórios \nCampos obrigatorios"
                    + " tem um * acima do campo");
            
            alert.showAndWait();
        } else {
            alert.setTitle("Cadastro concluido");
            alert.setHeaderText("Cadastro concluido com sucesso");
            alert.setContentText("Enviaremos um email de confirmação em breve");
            alert.showAndWait();
            
            System.exit(0);
        }
    } 

    @FXML
    private void combo(ActionEvent event) {
        
        int generoOutro = comboGenero.getSelectionModel().getSelectedIndex();
        
        if(generoOutro == 4){
            outrogenero.setDisable(false);
            
        }
        else {
            outrogenero.setDisable(true);
            outrogenero.clear();
        }
    }
}
