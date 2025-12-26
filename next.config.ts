import type { NextConfig } from "next";

const nextConfig: NextConfig = {
  async rewrites() {
    return [
      {
        source: "/admin7vsuo5zd/login",
        destination: "/admin7vsuo5zd-login"
      }
    ]
  }
};

export default nextConfig;
