package eu.andreatt.ejercicioq_dein;


import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Temporizador extends GridPane {
    @FXML
    private Label minDecena;
    @FXML
    private Label minUnidad;
    @FXML
    private Label segDecena;
    @FXML
    private Label segUnidad;

    private int tiempoEnSegundos;
    private final BooleanProperty fin = new SimpleBooleanProperty(false);
    private Timer timer;

    public Temporizador() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/eu/andreatt/ejercicioq_dein/fxml/Q.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void setTiempo(int minutos) {
        if (minutos < 1 || minutos > 99) {
            throw new IllegalArgumentException("El tiempo debe estar entre 1 y 99 minutos.");
        }
        this.tiempoEnSegundos = minutos * 60;
        actualizarPantalla();
    }

    public BooleanProperty finProperty() {
        return fin;
    }

    private void actualizarPantalla() {
        int minutos = tiempoEnSegundos / 60;
        int segundos = tiempoEnSegundos % 60;
        minDecena.setText(String.valueOf(minutos / 10));
        minUnidad.setText(String.valueOf(minutos % 10));
        segDecena.setText(String.valueOf(segundos / 10));
        segUnidad.setText(String.valueOf(segundos % 10));
    }

    public void iniciarCuentaAtras() {
        if (timer != null) {
            timer.cancel();
        }

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    if (tiempoEnSegundos > 0) {
                        tiempoEnSegundos--;
                        actualizarPantalla();
                    } else {
                        fin.set(true);
                        timer.cancel();
                    }
                });
            }
        }, 1000, 1000);
    }

    public void detenerCuentaAtras() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }
}
