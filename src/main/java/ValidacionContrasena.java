import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacionContrasena {


  public boolean validacionContrasena(String contrasena) {
    boolean resultado = false;
    if (contrasena.isEmpty() || contrasena == null) {
      throw new ContrsenaInvalidaException("Ingrese una contraseña");
    }
    if (cumpleFormato(contrasena)) {
      resultado = noEsContrasenaComun(contrasena);
    }
    return resultado;
  }

  private boolean cumpleFormato(String contrasena) {

    String regex = "^(?=.*[0-9])"
        + "(?=.*[a-z])(?=.*[A-Z])"
        + "(?=.*[@#$%^&+=])"
        + "(?=\\S+$).{8,20}$";

    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(contrasena);
    if (m.matches()) {
      return true;
    }
    throw  new ContrsenaInvalidaException("La contraseña no cumple el formato");
  }

  private boolean noEsContrasenaComun(String contrasena) {
    try {
      Path path = Paths.get("");
      String ruta = path.toAbsolutePath().toString();
      Scanner lee = new Scanner(new File(ruta + "\\contrasenas.txt"));
      String linea;

      while (lee.hasNextLine()) {
        linea = lee.nextLine();
        if (linea.contains(contrasena)) {
          throw new ContrsenaInvalidaException("Contraseña invalida");
        }
      }
      lee.close();
      return true;
    } catch (Exception ex) {
      throw  new ContrsenaInvalidaException(ex.getMessage());
    }
  }
}
