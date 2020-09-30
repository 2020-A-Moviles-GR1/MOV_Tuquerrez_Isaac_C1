
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

    name:{
      type:'string',
      required:true,
      unique:false
    },

    myData:{
      type:'string',
      required:true,
      unique:false
    },

    nodes:{
      collection:'node',
      via:'net'
    }

  },

};