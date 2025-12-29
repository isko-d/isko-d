import LogoutButton from "@/src/components/forms/LogoutButton";
import { ApiError } from "@/src/types/ApiError";
import apiFetch from "@/src/utils/apiFetch";
import { cookies } from "next/headers";
import Link from "next/link";
import { redirect } from "next/navigation";
import { ReactNode } from "react";

const AdminLayout = async ({ children }: { children: ReactNode }) => {
  const userCookies = await cookies();
  const token = userCookies.get("api_token");

  if (!token) redirect("/admin7vsuo5zd/login");

  return (
    <div className="flex flex-col min-h-screen bg-gray-100">
      <header className="h-12 bg-white shadow-md flex items-center justify-between px-6">
        <div className="text-xl font-semibold text-gray-800">Isko'D: One ID, All Access</div>
        <div className="flex items-center space-x-4">
          {/* User avatar / profile */}
          <div className="w-10 h-10 rounded-full bg-gray-300 flex items-center justify-center text-gray-700">
            SA
          </div>
          <LogoutButton />
        </div>
      </header>

      <div className="flex flex-1">
        {/* Sidebar */}
        <aside className="hidden md:flex md:flex-col w-64 text-white">
          <nav className="flex-1 p-4 space-y-2 bg-red-800">
            <Link href="/admin7vsuo5zd" className="block px-4 py-2 rounded hover:bg-red-700">
              Dashboard
            </Link>
            <Link href="/admin7vsuo5zd/users" className="block px-4 py-2 rounded hover:bg-red-700">
              Users
            </Link>
            <Link href="/admin7vsuo5zd/logs" className="block px-4 py-2 rounded hover:bg-red-700">
              Logs
            </Link>
            <Link href="/admin7vsuo5zd/settings" className="block px-4 py-2 rounded hover:bg-red-700">
              Settings
            </Link>
          </nav>
        </aside>

        <main className="flex-1 p-6 overflow-auto">{children}</main>
      </div>
    </div>
  );
};

export default AdminLayout;
