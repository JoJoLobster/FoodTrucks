/** @type {import('next').NextConfig} */
const nextConfig = {

    images: {
      remotePatterns: [
        {
          protocol: 'https',
          hostname: 'datasf.org',
          port: '',
          pathname: '/assets/img/**',
        },
      ],
    },
    
    async headers() {
        return [
            {
                // matching all API routes
                source: "/api/:path*",
                headers: [
                  { key: "Access-Control-Allow-Credentials", value: "false" },
                  { key: "Access-Control-Allow-Origin", value: "http://localhost:8080" },
                  { key: "Access-Control-Allow-Methods", value: "GET,DELETE,PATCH,POST,PUT" },
                  { key: "Access-Control-Allow-Headers", value: "Accept, Accept-Version, Content-Length, Content-MD5, Content-Type, Date" },
                ]
            },
        //     {
        //         source: "/api/special-data",
        //         headers: [
        //         ]
        //     }
        ]
    },

};

export default nextConfig;
