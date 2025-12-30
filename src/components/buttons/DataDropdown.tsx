import { useResourceContext } from "@/src/contexts/ResourceContext";
import { EllipsisVerticalIcon, PencilIcon, TrashIcon } from "@heroicons/react/24/outline";

const DataDropdown = ({item}: { item: Record<string, any> }) => {
  const { deleteItem, openEdit } = useResourceContext();

  const handleDelete = () => {
    deleteItem(item.id);
  }

  return (
    <div className="flex gap-2">
      <PencilIcon 
        className="size-6 text-gray-800 ml-auto hover:text-red-600 transition-colors cursor-pointer"
        onClick={() => openEdit(item)}
      />
      <TrashIcon 
        className="size-6 text-gray-800 ml-auto hover:text-red-600 transition-colors cursor-pointer"
        onClick={handleDelete}
      />
    </div>
  )
}

export default DataDropdown;
