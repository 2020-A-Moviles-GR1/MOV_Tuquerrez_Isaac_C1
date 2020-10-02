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

    link:{
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
