Livro_CRUD



#ATENÇÂO
Para o programa rodar ou compilar corretamente é necessário que vocês usem o java ou javac no diretorio root e nao no diretorio de cada pasta individual.

##Exemplo(No Exemplo usaremos a pasta exemplo_do_prof):

##parte 1:Para dar javac

cd src

cd Exemplo_do_prof

javac aed3\*.java

javac livros\*java

Pronto! você conseguiu compilar com exito!

##parte 2: 
Para rodar o programa usando java(ATENÇÂO se você estiver no windows em vez de usar a barra "\" tem que usar a barra nesse sentido / caso o contrário ele n aceitara)

java livros/ControleDeLivros

Parabéns você fez todos os passos com exito!
O programa seu deve estar rodando com exito!


#Como baixar o seu codigo usando o git?

##1:Primeiramente você deve ter o Git instalado no seu pc. 

##1.1: Caso ainda não tenha o link para download do git é https://git-scm.com/

##2:Logo depois você dever ir a pasta que deseja colocar o codigo baixado:

Exemplo:

cd documentos/codigos_git

git clone https://github.com/tetration/Online-Education-Project-for-College-Class

(Quando você digitar o comando acima ele deve te pedir seu login de usuario e senha no git e aí ele fara download com exito do nosso codigo para seu Hard Drive)


#Como atualizar a minha versao doo codigo compartilhado no git?

Primeiramente você deve ter o Git instalado no seu pc. Logo depois vc deve ir a pasta root do nosso projeto pelo powershell ou terminal do windows usando so comandos cds
quando chegar nela você usara os seguintes comandos para atualizar o nosso codigo:

git status (Esse vai te mostrar as mudanças que você fez no codigo)

git add .(Esse vai listar as mudanças que devem ser colocadas no proximo commit que você fizer o "." colocado no final indica que ele ira considerar tudo colocado dentro da pasta)

git stage .(Mesma coisa do anterior mas é necessario antes de usar o commit o "." colocaod no final indica que ele ira considerar todas as mudanças e arquivos adicionados na pasta)

git commit (Assim que você digitar esse comando ele vai te pedir um titulo e uma breve descrição da atualização que você fez no repositorio)

git push(Assim que você digitar esse comando ele vai dar upload das mudanças que você fez no nosso codigo para o repositorio na internet no site Github )
