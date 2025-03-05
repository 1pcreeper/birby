const layoutConstant = {
    header: {
        logo: {
            img: "https://flowbite.com/docs/images/logo.svg",
            to: "/"
        },
        navLinks: [
            {
                name: "Dashboard",
                to: "/dashboard"
            },
            {
                name: "Setting",
                to: "/setting"
            }
        ]
    }
} as const;
export default layoutConstant;