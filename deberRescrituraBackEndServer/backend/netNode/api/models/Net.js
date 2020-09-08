/**
 * Net.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

    index:{
      type:'number',
      required:true,
      unique:true
    },
    
    netSize:{
      type:'number',
      required:true,
      unique:false
    },

    nombre:{
      type:'string',
      required:true,
      unique:false
    },

    floatData:{
      type:'number',
      required:true,
      unique:false
    },

    doubleData:{
      type:'number',
      required:true,
      unique:false
    },

    booleanData:{
      type:'boolean',
      required:true,
      unique:false
    },

    nodes:{
      collection:'node',
      via:'net'
    }

  },

};

