# N3_Habib_Criptografia

# Alunos: Wesley Erik Sardi e Victor Hugo Bosse Kuhn

# ---------------------------- PLANEJAMENTO E OPERAÇÃO:
# Como você organizou seu código?

O código foi organizado em 4 arquivos destintos:
- O PRIMEIRO seria o GetKeys.java, disponibilizado pelo professor para que as chaves públicas e privadas sejam geradas;
- O SEGUNDO seria o TextChuck.java, também disponibilizado pelo professor, contendo algumas funções específicas para realizar as etapas do projeto mais facilmente. Estas são:
  1. O blockSize(), que retorna um número de caracteres Latin-1 (8-bit) que podem ser codificados em um BigInteger < N, sendo isso útil para a codigicação em RSA;
  2. A bigIntValue(), que retorna o o valor em BigInteger desse Chunk;
  3. O TextChunk(), que constrói o próprio TextChunk por meio de um BigInteger;
- O TERCEIRO seria o Encripta.java, que, basicamente, contém todo o processo de encriptação do texto contido no arquivo que é passada como argumento, no nosso caso o arquivo de texto é o texto.txt, e imprime este texto de forma encriptada em outro arquivo, também passado como argumento, que no nosso caso é o encrypted.txt;
- O QUARTO seria o Decripta.java, que contém o código de decriptação, que quando utilizado lê o arquivo com o texto encriptado e imprime sua versão decriptada em outro arquivo passado, também, como argumento.

# Que tipos de problemas você encontrou?

A princípio, encontramos problemas com a primeira linguagem utilizada, o JavaScript. Devido a alguns erros que aconteceram, trocamos para a linguagem Java e, deste modo, as coisas começaram a funcionar melhor. Porém, mesmo assim, tivemos algum problemas de lógica, visto que criamos a função de cálculo do tamanho dos Chunks do zero. Mas, depois de um tempo de esforço, o projeto funcionou sem muitos problemas.

# Que linguagem utilizou e por quê?

De início, JavaScript, mas, conforme explicado anteriormente, tivemos que trocar para Java, visto que um dos integrantes da nossa dupla tinha maior dominância nessa linguagem quando comparado a JavaScript.

# ---------------------------- TESTE:
# Como você testou seu código?

Geramos várias chaves diferentes e testamos para ver se a encriptação/decriptação funcionaria como o esperado. Além disso, testamos todas as funcionalidades do projeto utilizando "prints" e visualizando se os processos estavam funcionando e retornando o esperado.

# Que tipos de bugs você encontrou?

Em muitos momentos a encriptação ocorria de maneira errada e inseria, no arquivo passado como argumento, valores de criptografia que não condiziam com o esperado. O mesmo aconteceu, várias vezes, com o processo de decriptação, até que, futuramente, nós entendemos como a lógica toda funcionava e, deste modo, o programa funcionou como o esperado.

# O que funciona e o que não funciona?

Atualmente, tudo funciona.

# Há algum problema no código que você não conseguiu resolver?

Não, tudo está funcional.

# AVALIE O PROJETO:
# O que você aprendeu?

Posso considerar como aprendizado:
  - Lógica de programação;
  - Um melhor conhecimento sobre Criptografia;
  - Aprimoramento nas linguagem utilizadas.

# Valeu a pena?

Sim, valeu a pena, pois aprendizado nunca é demais.

# ---------------------------- APRENDIZADO:

Posso concluir que aprimoramos nossas lógica de programação, nosso conhecimento sobre Criptografia e sobre as linguagens utilizadas. Deste modo, teremos mais facilidade em entender como um processo de encriptação e decriptação ocorre e, portanto, será mais fácil de lidar com possíveis problemas futuros relacionados a isso. Bem como, quando relacionado às linguagem utilizadas, podemos concluir que enfrentar os problemas que a execução deste projeto ocasionou, tornou o nosso modo de lidar com estes mesmos muito mais eficaz e, portanto, em um possível projeto futuro, provavelmente, estes erros não serão cometidos novamente.
