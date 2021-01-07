  export const processoMask = value => {
    return value
      .replace(/\D/g, '') // substitui qualquer caracter que nao seja numero por nada
      .replace(/(\d{7})(\d)/, '$1-$2') // captura 2 grupos de numero o primeiro de 7 e o segundo de 1, apos capturar o primeiro grupo ele adiciona um - antes do segundo grupo de numero
      .replace(/(\d{2})(\d)/, '$1.$2')
      .replace(/(\d{4})(\d)/, '$1.$2')
      .replace(/(\d{1})(\d)/, '$1.$2')
      .replace(/(\d{2})(\d{1,2})/, '$1.$2')
      .replace(/(.\d{4})\d+?$/, '$1') // captura 4 numeros seguidos de um . e não deixa ser digitado mais nada
  }