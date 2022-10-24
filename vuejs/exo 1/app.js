const options = {
    data() {
      return {
        name: "",
        ingredients: "",
        preparation: "",
        time: "",
        number_people: "",

        recipes : [],
      };
    },
    methods: {
      addRecipe() {

        this.recipes.push({ 
            name: this.name,
            ingredients: this.ingredients,
            preparation: this.preparation,
            time: this.time,
            number_people: this.number_people,
        });

        this.name = "";
        this.ingredients = "";
        this.preparation = "";
        this.time = "";
        this.number_people = "";
      },
      removeRecipe(key) {
        if (key == 0){
          let firstelement = this.recipes.shift(key);
        }
        else{
          let supp = this.recipes.splice(key, key);
        }     
      },

    },
    
  };

  Vue.createApp(options).mount("#app");
