import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidacionContrasenaTest {
  @Test
  public void esContrasenaValida() {
    String contrasena = "agus123Y@";

    ValidacionContrasena validacion = new ValidacionContrasena();
    boolean resultado = validacion.validacionContrasena(contrasena);
    Assertions.assertTrue(resultado);
  }

  @Test
  public void noEsContrasenaValidaSinLetras() {
    String contrasena = "111123Y!";

    ValidacionContrasena validacion = new ValidacionContrasena();
    ContrsenaInvalidaException thrown = Assertions
        .assertThrows(ContrsenaInvalidaException.class, () -> {
          validacion.validacionContrasena(contrasena);
        });
    Assertions
        .assertEquals("La contraseña no cumple el formato",
            thrown.getMessage());
  }

  @Test
  public void noEsContrasenaValidaTieneVacio() {
    String contrasena = "";

    ValidacionContrasena validacion = new ValidacionContrasena();

    ContrsenaInvalidaException thrown = Assertions
        .assertThrows(ContrsenaInvalidaException.class, () -> {
          validacion.validacionContrasena(contrasena);
        });
    Assertions
        .assertEquals("Ingrese una contraseña",
            thrown.getMessage());
  }

  @Test
  public void noEsContrasenaValidaSinNumeros() {
    String contrasena = "agussssY!";

    ValidacionContrasena validacion = new ValidacionContrasena();
    ContrsenaInvalidaException thrown = Assertions
        .assertThrows(ContrsenaInvalidaException.class, () -> {
          validacion.validacionContrasena(contrasena);
        });
    Assertions
        .assertEquals("La contraseña no cumple el formato",
            thrown.getMessage());
  }

  @Test
  public void noEsContrasenaValidaSinCaracterEspecial() {
    String contrasena = "agus123Yf";

    ValidacionContrasena validacion = new ValidacionContrasena();
    ContrsenaInvalidaException thrown = Assertions
        .assertThrows(ContrsenaInvalidaException.class, () -> {
          validacion.validacionContrasena(contrasena);
        });
    Assertions
        .assertEquals("La contraseña no cumple el formato",
            thrown.getMessage());
  }

  @Test
  public void noEsContrasenaValidaCorta() {
    String contrasena = "agus123";

    ValidacionContrasena validacion = new ValidacionContrasena();
    ContrsenaInvalidaException thrown = Assertions
        .assertThrows(ContrsenaInvalidaException.class, () -> {
          validacion.validacionContrasena(contrasena);
        });
    Assertions
        .assertEquals("La contraseña no cumple el formato",
            thrown.getMessage());
  }

  @Test
  public void esContrasenaComun() {
    String contrasena = "123456qWe@";

    ValidacionContrasena validacion = new ValidacionContrasena();

    ContrsenaInvalidaException thrown = Assertions
        .assertThrows(ContrsenaInvalidaException.class, () -> {
      validacion.validacionContrasena(contrasena);
    });
    Assertions
        .assertEquals("Contraseña invalida",
            thrown.getMessage());
  }
}
