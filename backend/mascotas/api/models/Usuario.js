/**
 * Usuario.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

    //  ╔═╗╦═╗╦╔╦╗╦╔╦╗╦╦  ╦╔═╗╔═╗
    //  ╠═╝╠╦╝║║║║║ ║ ║╚╗╔╝║╣ ╚═╗
    //  ╩  ╩╚═╩╩ ╩╩ ╩ ╩ ╚╝ ╚═╝╚═╝


    //  ╔═╗╔╦╗╔╗ ╔═╗╔╦╗╔═╗
    //  ║╣ ║║║╠╩╗║╣  ║║╚═╗
    //  ╚═╝╩ ╩╚═╝╚═╝═╩╝╚═╝


    //  ╔═╗╔═╗╔═╗╔═╗╔═╗╦╔═╗╔╦╗╦╔═╗╔╗╔╔═╗
    //  ╠═╣╚═╗╚═╗║ ║║  ║╠═╣ ║ ║║ ║║║║╚═╗
    //  ╩ ╩╚═╝╚═╝╚═╝╚═╝╩╩ ╩ ╩ ╩╚═╝╝╚╝╚═╝

      cedula:{
          type:'string',
          required:true,
          columnName:'epn_cedula',
          unique:true,
          minLength:10,
          maxLength:16
      },
      nombre:{
          type:'string',
          required:true,
          columnName:'epn_nombre',
          unique:false,
          minLength:3,
          maxLength:16
      },
      email:{
          type:'string',
          required:false,
          columnName:'epn_mail',
          unique:false,
          minLength:10,
          maxLength:26,
  
      },
      estadoCivil:{
          type:'string',
          isIn:['soltero', 'casado', 'divorsiado', 'union libre']
      },
      password:{
          type:'string',
          regex:/^[a-zA-Z]\w{3,14}$/
      },

      pokemons:{
        collection:'pokemon',
        via:'usuario'
      }

  },

};

