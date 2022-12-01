package io.red.usermanager.app.controllers.v1;

import io.red.usermanager.core.usecases.ListarUsuario;
import io.red.usermanager.mocks.UsuarioMock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest(controllers = ListarUsuarioController.class)
@AutoConfigureMockMvc
class ListarUsuarioControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ListarUsuario listarUsuario;

    static String API_URL = "/v1/usuario";

    @Test
    @DisplayName("Deve listar usuario por id")
    void deveListarUsuarioAtivoPorId() throws Exception {
        var usuarioModel = UsuarioMock.toModel();

        BDDMockito.given(listarUsuario.usuarioPor(1L))
                .willReturn(usuarioModel);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(API_URL.concat("/" + 1L))
                .accept(MediaType.APPLICATION_JSON);

        mockMvc
                .perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1L))
                .andExpect(jsonPath("nome").value(usuarioModel.getNome()))
                .andExpect(jsonPath("nomeUsuario").value(usuarioModel.getNomeUsuario()))
                .andExpect(jsonPath("email").value(usuarioModel.getEmail()));

    }

    @Test
    void usuarioPor() {
    }
}
