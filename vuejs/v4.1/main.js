let MainMenu = {
  template: `<p>ca marche</p>`,
};

const options = {
  data(){
    return {}
  },
  methods: {},
  components: {
    MainMenu,
  },
}

Vue.createApp(options).mount("#app");