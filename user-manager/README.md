TESTE JAVA BACKEND PLENO:
Faça uma api em JAVA que faça a gerência de usuários.

Você vai ter as seguintes rotas/urls na sua api:

    Uma rota que cadastra um usuário (cada usuário tem nome, email, senha e nome de usuário. As senhas precisam ter pelo menos 6 caracteres).
    Uma rota para ver um perfil do usuário (essa rota só mostra nome, email e nome de usuário).
    Uma rota para editar um usuário.
    Uma rota para deletar um usuário.
    Validar autenticação e permissão da api com keycloak ou oauth.

Pontos extras:

    Não é possível cadastrar usuários com o mesmo nome de usuário e email
    A rota de deletar não apaga um registro no banco de dados, mas só faz uma exclusão lógica marca o usuário e marca o usuário como deletado (soft delete).
    Testes unitários
    Conhecimento em hibernate/jpa
    Conhecimento em banco de dados para realizar consultas em bases de dados com estruturas complexas.


fonte: https://github.com/adrianocarv/atech-java-backend-test