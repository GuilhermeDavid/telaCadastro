module Br.Senac.Telacadastro {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens Br.Senac.Telacadastro to javafx.fxml;
    exports Br.Senac.Telacadastro;
}
