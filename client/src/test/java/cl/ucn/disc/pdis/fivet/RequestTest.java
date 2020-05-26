/*
 * MIT License
 *
 * Copyright (c) 2020 Ignacio Fuenzalida Veas
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package cl.ucn.disc.pdis.fivet;
import cl.ucn.disc.pdis.fivet.zeroice.model.Contratos;
import cl.ucn.disc.pdis.fivet.zeroice.model.ContratosPrx;
import cl.ucn.disc.pdis.fivet.zeroice.model.Ficha;
import cl.ucn.disc.pdis.fivet.zeroice.model.Sexo;
import com.zeroc.Ice.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestTest {

    public static final String[] ARGS = {};
    /**
     * The logger.
     */
    private static final Logger log = LoggerFactory.getLogger(RequestTest.class);


    @Test
    public void getFichaTest(){

        log.debug("Starting the getFichaTest ..");

        String[] args = ARGS;
        try (Communicator communicator = Util.initialize(getInitializationData(args))) {

            // Running in port 8080
            ObjectPrx theProxy = communicator.stringToProxy(Contratos.class.getSimpleName() + ":default -p 8080 -z");

            ContratosPrx contratos = ContratosPrx.checkedCast(theProxy);

            if (contratos == null) {
                throw new IllegalStateException("Invalid TheSystem! (wrong proxy?)");
            }

            int n = 1;
            Ficha myFicha = contratos.obtenerFicha(n);


            Assertions.assertEquals(1, myFicha.id,"id not equal!");
            Assertions.assertEquals("18-11-1996", myFicha.fechaNacimiento,"FechaNacimiento not equal!");
            Assertions.assertEquals("Salchicha", myFicha.raza,"Raza not equal!");
            Assertions.assertEquals(Sexo.MACHO, myFicha.sexo,"Sexo not equal!");

            log.debug("Ficha especie: {}",myFicha.especie);
            log.debug("Ficha tipoPaciente: {}",myFicha.tipo);


        }

        log.debug("getFichaTest pass!");


    }


    /**
     * @param args to use as source.
     * @return the {@link InitializationData}.
     */
    private static InitializationData getInitializationData(String[] args) {

        // Properties
        final Properties properties = Util.createProperties(args);
        properties.setProperty("Ice.Package.model", "cl.ucn.disc.pdis.fivet.zeroice");

        // https://doc.zeroc.com/ice/latest/property-reference/ice-trace
        // properties.setProperty("Ice.Trace.Admin.Properties", "1");
        // properties.setProperty("Ice.Trace.Locator", "2");
        // properties.setProperty("Ice.Trace.Network", "3");
        // properties.setProperty("Ice.Trace.Protocol", "1");
        // properties.setProperty("Ice.Trace.Slicing", "1");
        // properties.setProperty("Ice.Trace.ThreadPool", "1");
        // properties.setProperty("Ice.Compression.Level", "9");
        properties.setProperty("Ice.Plugin.Slf4jLogger.java", "cl.ucn.disc.pdis.fivet.zeroice.Slf4jLoggerPluginFactory");

        InitializationData initializationData = new InitializationData();
        initializationData.properties = properties;

        return initializationData;
    }
}
